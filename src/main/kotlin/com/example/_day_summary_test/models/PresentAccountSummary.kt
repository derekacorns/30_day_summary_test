package com.example._day_summary_test.models

import com.expedia.graphql.annotations.GraphQLDescription

data class PresentAccountSummary(
        @GraphQLDescription("Placeholder")
        val summaryPeriod: Int,

        @GraphQLDescription("Placeholder")
        val total_invested: Int,

        @GraphQLDescription("Placeholder")
        val total_credits: Int,

        @GraphQLDescription("Placeholder")
        val total_recurring: Int,

        @GraphQLDescription("Placeholder")
        val total_one_time: Int,

        @GraphQLDescription("Placeholder")
        val total_dividends: Int,

        @GraphQLDescription("Placeholder")
        val total_gain_loss_value: Int,

        @GraphQLDescription("Placeholder")
        val total_gain_loss_percent: Int,

        @GraphQLDescription("Placeholder")
        val market_gain_loss_value: Int,

        @GraphQLDescription("Placeholder")
        val market_gain_loss_percent: Int

)