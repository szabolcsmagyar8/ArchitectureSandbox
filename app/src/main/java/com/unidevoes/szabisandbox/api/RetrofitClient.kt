package com.unidevoes.szabisandbox.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    private const val baseUrl = "https://quotable.io/"

    fun getInstance(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}