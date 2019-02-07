package com.example.trainingproject.model

import com.squareup.moshi.Json

data class Location(
    var street: String,
    @Json(name = "postcode")
    var postCode: String,
    var city: String
)