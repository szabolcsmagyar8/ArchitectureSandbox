package com.unidevoes.szabisandbox

import com.google.gson.annotations.SerializedName

data class Employees(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("data")
    val employees: List<Employee>,
    @SerializedName("message")
    val message: String
)
