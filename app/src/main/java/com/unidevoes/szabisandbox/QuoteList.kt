package com.unidevoes.szabisandbox

import com.google.gson.annotations.SerializedName

data class QuoteList(
    val count: Int = 0,
    val lastItemIndex: Int = 0,
    val page: Int = 0,
    val results: List<Result> = listOf(),
    val totalCount: Int = 0,
    val totalPages: Int = 0
)
