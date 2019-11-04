package com.muhammed.thasneem.smartnytimeapp.di.builder

import com.muhammed.thasneem.smartnytimeapp.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActiviyBuilderModule {

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun bindMainActivity(): MainActivity
}