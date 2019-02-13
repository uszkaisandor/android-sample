package com.example.trainingproject.model

import com.squareup.moshi.Json

data class User(
    var name: Name,
    var location: Location,
    @Json(name = "phone")
    var mobile: String,
    var picture: ProfilePicture
)