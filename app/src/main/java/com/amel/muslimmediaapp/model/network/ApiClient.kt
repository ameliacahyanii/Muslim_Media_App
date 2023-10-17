package com.amel.muslimmediaapp.model.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient { // Make single instance from client, global and resource eficiency
    fun provideApiService(): ApiService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor {
                val newRequest = it.request().newBuilder()
                    .addHeader("X-API-KEY", "8f84f99dd8b64ecb8af702b6e4b644ed")
                    .build()
                it.proceed(newRequest)
            }
            .readTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}