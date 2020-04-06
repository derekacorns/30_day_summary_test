package com.example._day_summary_test.graphql

import com.apollographql.apollo.ApolloClient
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import com.example._day_summary_test.models.PresentAccountSummary

@Component
class PresentGQLClient: GraphQLQueryResolver {

//    private val BASE_URL_GRAPHQL = "http://localhost:3000/graphql"
//    private val BASE_URL_SUBSCRIPTIONS = "ws://localhost:3000/subscriptions"
//    private val apolloClient: ApolloClient
//    private val subscriptionQueryClient: SubscriptionsQuery
//    private val subscriptionSubscriptionClient: SubscriptionUpdatedSubscription
//    init {
//        val logging = HttpLoggingInterceptor()
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//        val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .pingInterval(30, TimeUnit.SECONDS)
//                .build()
//        apolloClient = ApolloClient.builder()
//                .serverUrl(BASE_URL_GRAPHQL)
//                .okHttpClient(okHttpClient)
//                .subscriptionTransportFactory(WebSocketSubscriptionTransport.Factory(BASE_URL_SUBSCRIPTIONS, okHttpClient))
//                .build()
//        subscriptionQueryClient = SubscriptionsQuery.builder().build()
//        subscriptionSubscriptionClient = SubscriptionUpdatedSubscription.builder().build()
//        val observer = Rx2Apollo.from(getSubscriptionSubscriptionCall())
//        observer.subscribeWith(SubscriptionSubscriber ())
//    }
//    fun getApolloClient(): ApolloClient {
//        return apolloClient
//    }
    fun getPresentSummary(accountId: String): PresentAccountSummary = PresentAccountSummary(
            summaryPeriod = 5,
            total_invested = 10,
            total_credits = 10,
            total_recurring = 10,
            total_one_time = 10,
            total_dividends = 10,
            total_gain_loss_value = 10,
            total_gain_loss_percent = 10,
            market_gain_loss_value = 10,
            market_gain_loss_percent = 10
    )
}
