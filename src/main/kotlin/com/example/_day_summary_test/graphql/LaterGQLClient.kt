package com.example._day_summary_test.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class LaterGQLClient: GraphQLQueryResolver {
    fun getLaterSummary(accountId: String) {}
}

