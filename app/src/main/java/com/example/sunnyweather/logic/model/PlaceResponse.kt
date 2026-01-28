package com.example.sunnyweather.logic.model

import android.content.Context
import androidx.core.content.edit
import com.example.sunnyweather.SunnyWeatherApplication
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class PlaceResponse( val status: String, val query: String, val places: List<Place>)

data class Place( val name: String, val location: Location,
                  @SerializedName("formatted_address") val address: String)
                    //formatted_address is used in the web server
data class Location( val lat: Double, val lng: Double)

//test
//data class Test(val test: String){
//
//    init {
//        val sharePreferences = SunnyWeatherApplication.context.
//        getSharedPreferences("SunnyWeather", Context.MODE_PRIVATE)
//        sharePreferences.edit(){
//            putString("place", Gson().toJson())
//
//        }
//    }
//
//}

