package com.dallmeier.data.source.local.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dallmeier.data.model.WeatherResponse
import com.dallmeier.data.source.local.base.dao.WeatherDao
import com.dallmeier.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

/**
 * To manage data items that can be accessed and updated
 * & also maintain relationships between them
 *
 *
 */

@Database(entities = [WeatherResponse::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao() : WeatherDao

    class Callback @Inject constructor(
        private val database: Provider<AppDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}