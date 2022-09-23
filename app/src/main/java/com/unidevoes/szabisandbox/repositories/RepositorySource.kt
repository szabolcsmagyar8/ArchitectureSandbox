package com.unidevoes.szabisandbox.repositories

import com.unidevoes.szabisandbox.QuoteList
import kotlin.Result

interface RepositorySource {
    suspend fun getQuotes(): Result<QuoteList>
}
