package com.mongoose.starter.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Created by mongoose on 2021/02/16

class RetrofitAdapter<I : Any> private constructor(builder: Builder<I>) {

    var headerMap: Map<String, String>? = null

    var useGsonConverterFactory: Boolean = false

    var useLoggingInterceptor: Boolean = false

    init {
        headerMap = builder.headerMap

        useGsonConverterFactory = builder.useGsonConverterFactory

        useLoggingInterceptor = builder.useLoggingInterceptor
    }

    class Builder<I : Any>(val spec: Class<I>, private val baseUrl: String) {

        var headerMap: Map<String, String>? = null

        var useGsonConverterFactory: Boolean = false

        var useLoggingInterceptor: Boolean = false

        fun build() = RetrofitAdapter(this).create(spec, baseUrl)
    }

    private fun getHeaderInterceptor(map: Map<String, String>) = Interceptor { chain ->
        val request = chain.request().newBuilder()
        map.forEach { item ->
            request.addHeader(item.key, item.value)
        }
        return@Interceptor chain.proceed(request.build())
    }

    private fun getHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
        RetrofitAdapter::class.java
    }

    private fun createOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        headerMap?.let {
            client.addInterceptor(getHeaderInterceptor(it))
        }
        if (useLoggingInterceptor) {
            client.addInterceptor(getHttpLoggingInterceptor())
        }
        return client.build()
    }

    fun create(spec: Class<I>, baseUrl: String): I =
        Retrofit.Builder().apply {
            baseUrl(baseUrl)
            client(createOkHttpClient())
            if (useGsonConverterFactory) {
                addConverterFactory(GsonConverterFactory.create())
            }
        }.build().create(spec)
}