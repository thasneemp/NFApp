package com.muhammed.thasneem.smartnytimeapp.di.schedulers

import io.reactivex.Scheduler
import io.reactivex.annotations.NonNull

/****
 *
 *****/
interface SchedulerContract {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler
}