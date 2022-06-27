package com.dallmeier.data.source.local.base.dao

import androidx.room.*
import com.dallmeier.data.model.WeatherResponse

/**
 * Provides access to Photo underlying database
 * */
@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<WeatherResponse>?)

    @Query("SELECT * FROM WeatherResponse")
    suspend fun loadAll(): List<WeatherResponse>?

}