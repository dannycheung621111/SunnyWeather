package com.example.sunnyweather.logic.network

import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.PlaceResponse
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {
    val placeService = ServiceCreator.create<PlaceService>()
    suspend fun searchPlace(query: String) : PlaceResponse = placeService.searchPlace(query).await()

    private suspend fun <T> Call<T>.await(): T {        //this is a coroutine created outside the function
        return suspendCoroutine { continuation ->       //suspendCoroutine suspend the outside coroutine after running the block
            enqueue(object: Callback<T> {
                override fun onResponse(
                    call: Call<T?>,
                    response: Response<T?>
                ) {
                    val body = response.body()  //body() return  T
                    //debug
                    val info = body?.toString() ?: "null"
                    SunnyWeatherApplication.printInfo(" Call<T>.await()", body.toString())
                    if (body != null) continuation.resume(body)     //outside coroutine is resumed to run after resume() is executed.
                    else continuation.resumeWithException(
                        RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T?>, t: Throwable) {
//                    TODO("Not yet implemented")
                    continuation.resumeWithException(t)
                }

            })

        }
    }
}