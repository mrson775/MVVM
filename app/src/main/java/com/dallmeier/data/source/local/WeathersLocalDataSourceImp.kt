package com.dallmeier.data.source.local

import com.dallmeier.data.model.WeatherResponse
import com.dallmeier.data.source.local.base.AppDatabase


class WeathersLocalDataSourceImp(private val appDatabase: AppDatabase) : WeathersLocalDataSource {

    override suspend fun getWeathers(): List<WeatherResponse>? {
        return appDatabase.weatherDao().loadAll()
    }

    override suspend fun insertWeatherList(list: List<WeatherResponse>?) {
        return appDatabase.weatherDao().insertAll(list)
    }

}