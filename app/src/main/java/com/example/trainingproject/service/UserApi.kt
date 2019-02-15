package com.example.trainingproject.service

import com.example.trainingproject.model.UserWrapper
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("api")
    fun getUsers( @Query("results") userNumber: Int): Single<UserWrapper>
}