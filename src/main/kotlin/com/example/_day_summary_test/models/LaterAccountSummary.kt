package com.example._day_summary_test.models

import com.expedia.graphql.annotations.GraphQLDescription

data class LaterAccountSummary(
        @GraphQLDescription("Placeholder")
        val summaryPeriod: Integer,

        @GraphQLDescription("Placeholder")
        val total_invested: Float?,

        @GraphQLDescription("Placeholder")
        val total_credits: Float?,

        @GraphQLDescription("Placeholder")
        val total_recurring: Float?,

        @GraphQLDescription("Placeholder")
        val total_one_time: Float?,

        @GraphQLDescription("Placeholder")
        val total_dividends: Float?,

        @GraphQLDescription("Placeholder")
        val total_gain_loss_value: Float?,

        @GraphQLDescription("Placeholder")
        val total_gain_loss_percent: Float?,

        @GraphQLDescription("Placeholder")
        val market_gain_loss_value: Float?,

        @GraphQLDescription("Placeholder")
        val market_gain_loss_percent: Float?

)