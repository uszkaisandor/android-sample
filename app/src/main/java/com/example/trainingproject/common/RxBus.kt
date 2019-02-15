package com.example.trainingproject.common

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Global event handler bus. Similar to EventBus.
 * Just a casual command design pattern.
 */
object RxBus {

    private val publisher = PublishSubject.create<Any>()

    /**
     * Emit [event] of type [Any] which can be intercepted by [listen].
     */
    fun publish(event: Any) {
        publisher.onNext(event)
    }

    /**
     * Listen for any emission previously started by [publish] and act on it.
     * This callback receives the emitted object of type [eventType].
     */
    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}