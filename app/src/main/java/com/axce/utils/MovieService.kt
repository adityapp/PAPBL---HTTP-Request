package com.axce.utils

import com.axce.models.Movie
import retrofit2.Call
import retrofit2.http.Url
import retrofit2.http.GET



interface MovieService{
    @GET
    fun getMovie(@Url url: String): Call<Movie>
}