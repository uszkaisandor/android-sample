package com.example.trainingproject.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Use this class to control your disposables in one place.
 * You can add disposables in the creation lifecycle states or dispose them at once on the destroyer states.
 *
 * Eg. you can add them in onStart and dispose them in onStop
 */
class DisposableManager {

    private var compositeDisposable: CompositeDisposable? = null
        get() {
            if (field == null || field!!.isDisposed) {
                compositeDisposable = CompositeDisposable()
            }
            return field
        }

    fun add(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }

    fun dispose() {
        compositeDisposable?.dispose()
    }
}