package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log

class SunnyWeatherApplication : Application(){

    companion object{
        const val TOKEN = "abc"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun printInfo(tag: String, info: String){
            Log.d(tag, "printInfo: $info")
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}