package com.example.sunnyweather.logic

import androidx.lifecycle.liveData
import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

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
//            Result.failure<List<Place>>(e)    //Failure will return a Result object encapsulates an exception.
            //debug
            val info = e.toString()
            SunnyWeatherApplication.printInfo(" searchPlaces", info)

            Result.failure(e)
        }
        emit(result)        //suspend function, set the liveData the new value.
    }
}