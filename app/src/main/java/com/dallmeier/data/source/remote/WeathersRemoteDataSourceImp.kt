package com.dallmeier.data.source.remote

import com.dallmeier.data.model.WeatherResponse
import com.dallmeier.data.source.remote.base.ApiService
import com.google.gson.JsonObject


class WeathersRemoteDataSourceImp(private val apiService: ApiService) : WeathersRemoteDataSource {

    override suspend fun getWeathers() : JsonObject{
        return apiService.getWeathers()
    }
}