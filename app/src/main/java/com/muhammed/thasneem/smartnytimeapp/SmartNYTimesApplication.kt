package com.muhammed.thasneem.smartnytimeapp

import android.app.Activity
import android.app.Application
import android.content.Context
import com.muhammed.thasneem.smartnytimeapp.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SmartNYTimesApplication : Application(), HasActivityInjector {
    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        // Initialize the dagger app component
        initializeComponent()
    }

    init {
        instance = this
    }

    /**
     * Initializing dagger for dependency injection
     */
    private fun initializeComponent() {
        AppInjector.init(this)
    }

    companion object {
        private var instance: SmartNYTimesApplication? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        fun getInstance(): SmartNYTimesApplication? {
            return instance
        }
    }
}