package com.muhammed.thasneem.smartnytimeapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muhammed.thasneem.smartnytimeapp.base.framework.ViewModelFactory
import com.muhammed.thasneem.smartnytimeapp.di.keys.ViewModelKey
import com.muhammed.thasneem.smartnytimeapp.viewmodel.HomeFragmentViewModel
import com.muhammed.thasneem.smartnytimeapp.viewmodel.ItemDetailsFragmentViewModel
import com.muhammed.thasneem.smartnytimeapp.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainActivityViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    abstract fun bindHomeFragmentViewModel(homeViewModel: HomeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ItemDetailsFragmentViewModel::class)
    abstract fun bindItemDetailsFragmentViewModel(itemDetailsFragmentViewModel: ItemDetailsFragmentViewModel): ViewModel


    @Binds
    internal abstract fun bindsViewModelFactory(viewModelProviderFactory: ViewModelFactory): ViewModelProvider.Factory
}