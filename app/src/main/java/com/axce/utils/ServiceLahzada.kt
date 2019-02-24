package com.axce.utils

import android.app.Activity
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceLahzada (val context: Context, val baseUrl: String){
    private val activity = context as Activity

    private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val apiService = retrofit.create(LahzadaService::class.java)

    fun getApiService(): LahzadaService{
        return apiService
    }
}