package com.example.sunnyweather.logic

import androidx.lifecycle.liveData
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO){  //return LiveData<Result<List<Place>>>
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlace(query)      //this is a suspend fun
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException(
                    "Response status is ${placeResponse.status}"))
            }
        }catch(e: Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}