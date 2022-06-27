package com.dallmeier.data.source.remote.base

import com.google.gson.JsonObject
import retrofit2.http.GET

interface ApiService {
    @GET("astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0")
    suspend fun getWeathers():JsonObject
}