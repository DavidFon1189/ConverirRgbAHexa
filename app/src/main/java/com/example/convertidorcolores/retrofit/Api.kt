package com.example.convertidorcolores.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/timezone/America/Mexico_City")
    fun getInfo(): Call<String>
}