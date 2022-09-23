package com.unidevoes.szabisandbox.api

import com.unidevoes.szabisandbox.Employees
import com.unidevoes.szabisandbox.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface EmployeesApi {
    @GET("/employees")
    suspend fun getEmployees(): Response<Employees>

    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}