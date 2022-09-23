package com.unidevoes.szabisandbox.repositories

import com.unidevoes.szabisandbox.api.EmployeesApi
import com.unidevoes.szabisandbox.QuoteList
import com.unidevoes.szabisandbox.api.RetrofitHelper
import kotlin.Result

class RemoteRepository : RepositorySource {
    override suspend fun getQuotes(): Result<QuoteList> {
        val employeesApi = RetrofitHelper.getInstance().create(EmployeesApi::class.java)
        return runCatching {
            employeesApi.getQuotes().body() ?: throw Exception("sajtos")
        }
    }
}