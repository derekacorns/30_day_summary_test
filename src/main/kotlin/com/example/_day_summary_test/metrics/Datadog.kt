package io.acorns.hermes.metrics

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.ZoneOffset
import org.slf4j.Logger
import org.slf4j.LoggerFactory

enum class MetricType(val type: String) {
    COUNT("count"),
    GAUGE("gauge"),
    HISTOGRAM("histogram")
}

/**
 * The Datadog Metrics implementation here essentially builds our metric data into a
 * very specific format and logs it. Our stdout logs go to Cloudwatch and we have a
 * Log Subscriber configured to watch for this format and forward to Datadog.
 *
 * Example Usage:
 *
 * Datadog.increment("test_action.count", 1, "action_value:12")
 *
 *
 * Naming stats:
 *
 * Stats should be categorically separated by periods (.) and multiple words should be
 * separated by underscores. Commonly this is represented by <thing>.<action>.<detail>
 * All stat names will be automatically prefixed by the service name (hermes).
 *
 * Example:
 *
 * "later_investment.initiated.amount" then becomes "hermes.later_investment.initiated.amount"
 *
 * For more information on the different types please refer to the Datadog documentation:
 * https://docs.datadoghq.com/developers/metrics/types/
 *
 *
 * Tags:
 *
 * Metric tags are a an optional way to include additional segmentation data about the
 * metric being recorded. For an example like an investment could include the source bank
 * which could then be a filter in Datadog. DO NOT include super unique tags such as ID's,
 * timestamps, or random dollar amounts, as these will cause problems in Datadog. Tags
 * must be formatted as a Map of string/string key/values, where each key/value will be
 * formatted for you into the colon separated concatenation required.
 *
 * Example:
 *
 * mapOf("foo" to "bar") then becomes "#foo:bar"
 *
 * See the buildTagString() method for more details.
 *
 */

object Datadog {
    private val env = System.getenv("STAGE") ?: "development"
    internal var log: Logger = LoggerFactory.getLogger(Datadog::class.java.name)!!

    fun increment(stat: CustomMetrics, value: BigDecimal = BigDecimal(1), tags: Map<String, String> = mapOf()) {
        send(stat, value, MetricType.COUNT, tags)
    }

    fun decrement(stat: CustomMetrics, value: BigDecimal = BigDecimal(1), tags: Map<String, String> = mapOf()) {
        send(stat, -value, MetricType.COUNT, tags)
    }

    fun histogram(stat: CustomMetrics, value: BigDecimal = BigDecimal(1), tags: Map<String, String> = mapOf()) {
        send(stat, value, MetricType.HISTOGRAM, tags)
    }

    fun gauge(stat: CustomMetrics, value: BigDecimal = BigDecimal(1), tags: Map<String, String> = mapOf()) {
        send(stat, value, MetricType.GAUGE, tags)
    }

    private fun send(stat: CustomMetrics, value: BigDecimal, type: MetricType, extraTags: Map<String, String>) {
        val dateString: String = LocalDateTime.now().atZone(ZoneOffset.UTC).toEpochSecond().toString()

        val parts: List<String> = listOf(
            "MONITORING",
            dateString,
            value.toString(),
            type.type,
            // auto-prefix stats with service name
            "hermes.${stat.value}",
            buildTagString(extraTags)
        )

        // Example: MONITORING|1584122832|1|count|hermes.test.metric|#env:staging
        log.info(parts.joinToString("|"))
    }

    private fun buildTagString(extraTags: Map<String, String>): String {
        // default environment tag included with every metric
        val tagMap = mutableMapOf(
                "env" to env
        )

        // add metric specific tags
        tagMap.putAll(extraTags)

        // convert all to the "key:value" string format
        val tagList = tagMap.map { "${it.key}:${it.value}" }

        // combine all and prepend with #
        return "#${tagList.joinToString(",")}"
    }
}
