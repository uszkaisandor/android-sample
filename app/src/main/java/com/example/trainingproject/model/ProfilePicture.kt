package com.example.trainingproject.model

import com.squareup.moshi.Json

class ProfilePicture (
    @Json(name = "large")
    var picture: String?
)
