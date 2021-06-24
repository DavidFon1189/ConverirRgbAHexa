package com.example.convertidorcolores.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object RetrofitClietn {

    private val BASE_URL = "http://worldtimeapi.org/api"
    private val API_TIMER = 60

    fun provideAPIService(): Api? {
        return provideRetrofit(BASE_URL).create(Api::class.java)
    }

    fun provideRetrofit(baseUrl: String) : Retrofit {
        val headerAuthorizationInterceptor: Interceptor = object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                var request: Request = chain.request()
                request = request.newBuilder().build()
                return chain.proceed(request)
            }
        }
        val builder = retrofit2.Retrofit.Builder()
        val httpClient = OkHttpClient.Builder()
        val clientTimer =
            httpClient.connectTimeout(API_TIMER.toLong(), TimeUnit.SECONDS)
                .readTimeout(API_TIMER.toLong(), TimeUnit.SECONDS)
                .writeTimeout(API_TIMER.toLong(), TimeUnit.SECONDS)
                .addInterceptor(headerAuthorizationInterceptor)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
        return builder.client(clientTimer)
            .client(clientTimer)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}