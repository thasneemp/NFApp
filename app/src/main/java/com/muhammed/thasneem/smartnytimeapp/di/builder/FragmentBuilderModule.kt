package com.muhammed.thasneem.smartnytimeapp.di.builder

import com.muhammed.thasneem.smartnytimeapp.view.fragments.HomeFragment
import com.muhammed.thasneem.smartnytimeapp.view.fragments.ItemDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilderModule {


    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun contributeItemDetailsFragment(): ItemDetailsFragment
}