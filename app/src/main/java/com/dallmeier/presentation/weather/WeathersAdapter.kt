package com.dallmeier.presentation.weather

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dallmeier.myapplication.R
import com.dallmeier.myapplication.databinding.HolderWeatherItemBinding
import com.dallmeier.presentation.model.Weather
import kotlin.properties.Delegates


class WeathersAdapter(ctx: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context = ctx;
    var weatherList: List<Weather> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderWeatherBinding =
            HolderWeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(holderWeatherBinding)
    }

    override fun getItemCount(): Int = weatherList.size
    private fun getItem(position: Int) = weatherList[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WeatherViewHolder).onBind(getItem(position))
    }

    private inner class WeatherViewHolder(private val holderWeatherItemBinding: HolderWeatherItemBinding) :
        RecyclerView.ViewHolder(holderWeatherItemBinding.root) {
        fun onBind(weather: Weather?) {

            with(holderWeatherItemBinding) {
                weatherTitle.text =
                    context.getString(R.string.transparency) + weather?.transparency.toString()
            }
        }
    }
}