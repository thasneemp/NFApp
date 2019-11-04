package com.muhammed.thasneem.smartnytimeapp.di.modules


import com.muhammed.thasneem.smartnytimeapp.di.schedulers.SchedulerProvider
import com.muhammed.thasneem.smartnytimeapp.base.BaseConfigurations
import com.muhammed.thasneem.smartnytimeapp.di.schedulers.SchedulerContract
import com.muhammed.thasneem.smartnytimeapp.webservice.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiKeyInterceptor: ApiKeyInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseConfigurations.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Provides
    @Singleton
    internal fun provideApiKeyInterceptor(): ApiKeyInterceptor {
        return ApiKeyInterceptor(BaseConfigurations.API_KEY)
    }

    companion object {
        private const val CONNECTION_TIMEOUT: Long = 30000
        private const val READ_TIMEOUT: Long = 30000
        private const val WRITE_TIMEOUT: Long = 30000
    }

    @Provides
    @Singleton
    fun provideScheduler(): SchedulerContract {
        return SchedulerProvider()
    }

}
