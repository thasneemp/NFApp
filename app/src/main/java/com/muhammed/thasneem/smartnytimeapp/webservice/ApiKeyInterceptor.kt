package com.muhammed.thasneem.smartnytimeapp.webservice

import okhttp3.Interceptor
import okhttp3.Response

/**
 * This interceptor is helping to inject api key in before the network call for all api
 */
class ApiKeyInterceptor constructor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var addQueryParameter = chain.request()
        val build = addQueryParameter.url().newBuilder().addQueryParameter("api-key", apiKey).build()
        addQueryParameter = addQueryParameter.newBuilder().url(build).build()
        return chain.proceed(addQueryParameter)
    }
}