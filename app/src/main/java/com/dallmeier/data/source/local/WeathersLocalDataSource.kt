package com.dallmeier.data.source.local

import com.dallmeier.data.model.WeatherResponse

interface WeathersLocalDataSource {

    suspend fun getWeathers(): List<WeatherResponse>?

    suspend fun insertWeatherList(list: List<WeatherResponse>?)

}