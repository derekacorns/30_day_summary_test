package com.example._day_summary_test.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class PresentGQLClient: GraphQLQueryResolver {
    fun getPresentSummary(accountId: String) {}
}
