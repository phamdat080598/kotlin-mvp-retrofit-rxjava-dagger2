package com.example.myapplication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {
    val getAPIService = fun (): APIService{
        return Retrofit.Builder()
            .baseUrl("http://192.168.99.221/testAPI/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getClient())
            .build()
            .create(APIService::class.java)
    }
    val getClient = fun(): OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .build()
    }
}