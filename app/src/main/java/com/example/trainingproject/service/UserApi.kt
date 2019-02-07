package com.example.trainingproject.service

import com.example.trainingproject.model.UserWrapper
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {

    @GET("api/")
    fun getUsers(): Observable<UserWrapper>
}