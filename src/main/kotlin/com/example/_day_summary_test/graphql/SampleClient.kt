//package com.example._day_summary_test.graphql
//
//import com.apollographql.apollo.ApolloCall
//import com.apollographql.apollo.ApolloClient
//import com.apollographql.apollo.ApolloSubscriptionCall
//import com.apollographql.apollo.rx2.Rx2Apollo
//import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport
//import fr.client.apollo.mutations.SubscriptionMutation
//import fr.client.apollo.queries.SubscriptionsQuery
//import fr.client.apollo.subscriptions.SubscriptionUpdatedSubscription
//import fr.apollo.type.MessageInput
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import java.util.concurrent.TimeUnit
//object ApolloClient {
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
//    fun getSubscriptionQueryClient(): SubscriptionsQuery {
//        return subscriptionQueryClient
//    }
//    fun getSubscriptionMutationClient(id_user: String, data: MutableList<MessageInput>): SubscriptionMutation {
//        val builder = SubscriptionMutation.builder()
//        builder.id_user(id_user)
//        builder.data(data)
//        return builder.build()
//    }
//    fun getSubscriptionSubscriptionClient(): SubscriptionUpdatedSubscription {
//        return subscriptionSubscriptionClient
//    }
//    fun getSubscriptionQueryCall(): ApolloCall<SubscriptionsQuery.Data> {
//        return apolloClient.query(subscriptionQueryClient)
//    }
//    fun getSubscriptionMutationCall(mutationBuilded: SubscriptionMutation): ApolloCall<SubscriptionMutation.Data> {
//        return apolloClient.mutate(mutationBuilded)
//    }
//    fun getSubscriptionSubscriptionCall(): ApolloSubscriptionCall<SubscriptionUpdatedSubscription.Data> {
//        return apolloClient.subscribe(subscriptionSubscriptionClient)
//    }
//}