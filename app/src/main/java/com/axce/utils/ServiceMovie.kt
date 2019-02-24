package com.axce.utils

import android.app.Activity
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceMovie (val context: Context, val baseUrl: String){
    private val activity = context as Activity

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(MovieService::class.java)

    fun getApiService(): MovieService{
        return apiService
    }
}