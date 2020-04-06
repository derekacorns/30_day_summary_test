package com.example._day_summary_test.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import com.example._day_summary_test.models.PresentAccountSummary

@Component
class PresentGQLClient: GraphQLQueryResolver {
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
