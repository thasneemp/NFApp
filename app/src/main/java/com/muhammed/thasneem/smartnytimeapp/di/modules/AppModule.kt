package com.muhammed.thasneem.smartnytimeapp.di.modules

import com.muhammed.thasneem.smartnytimeapp.webservice.SmartAppApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    internal fun provideKBApiService(retrofit: Retrofit): SmartAppApiService {
        return retrofit.create(SmartAppApiService::class.java)
    }
}