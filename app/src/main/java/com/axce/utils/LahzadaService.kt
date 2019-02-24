package com.axce.utils

import com.axce.models.Item
import com.axce.models.Toko
import retrofit2.Call
import retrofit2.http.*

interface LahzadaService{

    @POST("toko")
    fun createToko(
        @Header("Content-Type") content: String,
        @Query("nama") nama : String,
        @Query("alamat") alamat: String,
        @Query("no_tlp") noTlp: String
    ): Call<Toko>

    @GET("toko")
    fun getToko(
        @Header("Content-Type") content: String
    ): Call<ArrayList<Toko>>

    @PUT("toko/{id}")
    fun updateToko(
        @Header("Content-Type") content: String,
        @Path("id") id: Int,
        @Query("nama") nama : String,
        @Query("alamat") alamat: String,
        @Query("no_tlp") noTlp: String
    ): Call<Toko>

    @DELETE("toko/{id}")
    fun deleteToko(
        @Header("Content-Type") content: String,
        @Path("id") id: Int
    ): Call<Toko>

    @POST("item")
    fun createItem(
        @Header("Content-Type") content: String,
        @Query("nama") nama : String,
        @Query("harga") harga: String,
        @Query("id_toko") idToko: Int
    ): Call<Item>

    @GET("item")
    fun getItem(
        @Header("Content-Type") content: String
    ): Call<ArrayList<Item>>

    @PUT("item/{id}")
    fun updateItem(
        @Header("Content-Type") content: String,
        @Path("id") id: Int,
        @Query("nama") nama : String,
        @Query("harga") harga: String,
        @Query("id_toko") idToko: Int
    ): Call<Item>

    @DELETE("item/{id}")
    fun deleteItem(
        @Header("Content-Type") content: String,
        @Path("id") id: Int
    ): Call<Item>
}