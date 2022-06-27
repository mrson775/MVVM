package com.dallmeier.domain.repository

import com.dallmeier.domain.model.WeatherEntity

interface WeatherRepository  {
    suspend fun getWeatherList(networkAvailability : Boolean) : List<WeatherEntity>?
}