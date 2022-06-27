package com.dallmeier.data.source.remote

import com.google.gson.JsonObject

interface WeathersRemoteDataSource {

    suspend fun getWeathers() : JsonObject
}