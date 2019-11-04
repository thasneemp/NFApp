package com.muhammed.thasneem.smartnytimeapp.di.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

/****
 *
 *****/
const val SUBSCRIBER_ON = "SubscribeOn"
const val OBSERVER_ON = "ObserverOn"

class SchedulerProvider : SchedulerContract {
    @Named(SUBSCRIBER_ON)
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    @Named(OBSERVER_ON)
    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}