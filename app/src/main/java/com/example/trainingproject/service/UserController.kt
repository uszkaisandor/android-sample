package com.example.trainingproject.service

import com.example.trainingproject.model.UserWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserController{

    private val BASE_URL = "http://randomuser.me/"

    val compositeDisposable = CompositeDisposable()

    fun getUsers(handler: HandleResponse<UserWrapper>) {

        val api: UserApi = ApiClient.getClient(HttpClientFactory.getClient(), BASE_URL)
            .create(UserApi::class.java)

        compositeDisposable.add(api
            .getUsers(10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(handler::onResponse, handler::onError)
        )
    }

    fun destroy(){
        compositeDisposable.clear()
    }
}