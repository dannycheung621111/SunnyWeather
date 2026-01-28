package com.example.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sunnyweather.R
import com.example.sunnyweather.databinding.PlaceItemBinding
import com.example.sunnyweather.logic.model.Place

class PlaceAdapter(private val fragment: Fragment, private val placeList: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val placeName: TextView = view.findViewById(R.id.placeName)
//        val placeAddress: TextView = view.findViewById(R.id.placeAddress)
//    }

    inner class ViewHolder(val binding: PlaceItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
//        return ViewHolder(view)
        val bind = PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
//        TODO("Not yet implemented")
        val place = placeList.get(position)
//        holder.placeAddress.text = place.address
//        holder.placeName.text = place.name
        holder.binding.apply{
            placeAddress.text = place.address
            placeName.text = place.name
        }
    }
//    override fun getItemCount(): Int {
////        TODO("Not yet implemented")
//        return placeList.size
//    }
    override fun getItemCount() = placeList.size


}