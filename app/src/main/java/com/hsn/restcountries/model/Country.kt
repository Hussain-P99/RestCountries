package com.hsn.restcountries.model

import com.squareup.moshi.Json

data class Country(
    val name: String,
    val region: String,
    val population: Long,
    @Json(name = "flag") val flagUrl: String,
    val capital: String,
    val languages: List<language>,
    val currencies: List<currency>
)

data class language(
    val name: String
)

data class currency(
    val name: String
)