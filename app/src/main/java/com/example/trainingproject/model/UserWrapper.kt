package com.example.trainingproject.model

import com.squareup.moshi.Json

class UserWrapper (
    @Json(name = "results")
    var users: List<User>
)