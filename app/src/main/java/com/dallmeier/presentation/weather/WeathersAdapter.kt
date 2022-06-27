package com.dallmeier.presentation.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dallmeier.myapplication.databinding.HolderWeatherItemBinding
import com.dallmeier.presentation.model.Weather
import kotlin.properties.Delegates


class WeathersAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var photoList: List<Weather> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPhotoBinding = HolderWeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(holderPhotoBinding)
    }

    override fun getItemCount(): Int = photoList.size

    private fun getItem(position: Int) = photoList[position]

    override fun getItemId(position: Int): Long = position.toLong()


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoViewHolder).onBind(getItem(position))
    }

    private inner class PhotoViewHolder(private val holderWeatherItemBinding: HolderWeatherItemBinding) :
        RecyclerView.ViewHolder(holderWeatherItemBinding.root) {

        fun onBind(photo: Weather?) {

            with(holderWeatherItemBinding) {
               weatherTitle.text = "transparency:"+ photo?.transparency.toString()
                }
        }
    }
}