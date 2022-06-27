package com.dallmeier.data.repository


import com.dallmeier.data.model.WeatherResponse
import com.dallmeier.data.source.local.WeathersLocalDataSource
import com.dallmeier.data.source.remote.WeathersRemoteDataSource
import com.dallmeier.domain.model.WeatherEntity
import com.dallmeier.domain.repository.WeatherRepository
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken

/**
 * This class is responsible to choose a source for fetching data
 * [photosLocalDataSource] to access/modify local data
 * [photosRemoteDataSource] to access/update remote data
 *
 *
 * */
class WeathersRepositoryImp constructor(
    private val photosRemoteDataSource: WeathersRemoteDataSource,
    private val photosLocalDataSource: WeathersLocalDataSource,
    private val gson: Gson
) : WeatherRepository {

    override suspend fun getWeatherList(networkAvailability: Boolean): List<WeatherEntity>? {
        if (networkAvailability) {
            photosRemoteDataSource.getWeathers().also {
                val mResArr: JsonArray = it.getAsJsonArray("dataseries")
                val type = object : TypeToken<List<WeatherResponse?>?>() {}.type
                val weathers: List<WeatherResponse> = gson.fromJson(mResArr, type)
                photosLocalDataSource.insertWeatherList(weathers)
                return weathers.map { weatherResponse ->
                    weatherResponse.toDomain()
                }
            }

        } else return photosLocalDataSource.getWeathers()?.map {
            it.toDomain()
        }

    }
}