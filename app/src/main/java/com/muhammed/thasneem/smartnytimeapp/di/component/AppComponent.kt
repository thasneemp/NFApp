package com.muhammed.thasneem.smartnytimeapp.di.component

import android.app.Application
import com.muhammed.thasneem.smartnytimeapp.SmartNYTimesApplication
import com.muhammed.thasneem.smartnytimeapp.di.builder.ActiviyBuilderModule
import com.muhammed.thasneem.smartnytimeapp.di.modules.AppModule
import com.muhammed.thasneem.smartnytimeapp.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, NetworkModule::class, ActiviyBuilderModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(smartNYTimesApplication: SmartNYTimesApplication)
}