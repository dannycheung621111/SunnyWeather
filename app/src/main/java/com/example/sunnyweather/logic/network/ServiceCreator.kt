package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASEURL = "https://api.caiyunapp.com/"
//    private const val BASEURL = "https://api.caiyuna.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>) : T = retrofit.create(serviceClass)  //create a serviceClass instance
    inline fun <reified T> create() = create(T::class.java)

}