package com.example.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place

class PlaceViewModel: ViewModel() {
    private val searchLiveData = MutableLiveData<String>() //LiveDate<String>
    val placelist = ArrayList<Place>()

    val placeLiveData = searchLiveData.switchMap { query -> //LiveData<Result<List<Place>>>
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String){
        searchLiveData.value = query
    }
}