package com.muhammed.thasneem.smartnytimeapp.webservice

import com.muhammed.thasneem.smartnytimeapp.base.response.ApiResponse
import com.muhammed.thasneem.smartnytimeapp.base.response.ResponseListener
import com.muhammed.thasneem.smartnytimeapp.base.response.ResponseStatus
import com.muhammed.thasneem.smartnytimeapp.di.schedulers.SchedulerContract
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

open class BaseRepository(val scheduler: SchedulerContract) {

    /**
     * This method perfroms the asynchronous network request using the scheduler
     * @param observable : Observable network request
     * @param responseListener: ResponseListener Callback
     */
    fun <T : Any> performRequest(
        observable: Observable<T>,
        responseListener: ResponseListener<T>
    ): Disposable {
        return observable.subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .doOnSubscribe { responseListener.onStart() }
            .doAfterTerminate { responseListener.onFinish() }
            .subscribe({ result: T ->
                responseListener.onResponse(
                    ApiResponse(
                        ResponseStatus.SUCCESS,
                        result,
                        null
                    )
                )
            },
                { error: Throwable? ->
                    responseListener.onResponse(
                        ApiResponse(
                            ResponseStatus.FAILURE,
                            null,
                            error
                        )
                    )
                })

    }

    /**
     * This method perfroms the asynchronous network request using the scheduler
     * @param observable : Observable network request
     * @param responseListener: ResponseListener Callback
     */
    fun <T : Any> performRequest(
        flowable: Flowable<T>,
        responseListener: ResponseListener<T>
    ): Disposable {
        return flowable.subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .doOnSubscribe { responseListener.onStart() }
            .doAfterTerminate { responseListener.onFinish() }
            .subscribe({ result: T ->
                responseListener.onResponse(
                    ApiResponse(
                        ResponseStatus.SUCCESS,
                        result,
                        null
                    )
                )
            },
                { error: Throwable? ->
                    responseListener.onResponse(
                        ApiResponse(
                            ResponseStatus.FAILURE,
                            null,
                            error
                        )
                    )
                })

    }
}

