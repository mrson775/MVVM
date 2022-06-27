package com.dallmeier.di

import com.dallmeier.data.repository.WeathersRepositoryImp
import com.dallmeier.data.source.local.WeathersLocalDataSource
import com.dallmeier.data.source.local.WeathersLocalDataSourceImp
import com.dallmeier.data.source.local.base.AppDatabase
import com.dallmeier.data.source.remote.WeathersRemoteDataSource
import com.dallmeier.data.source.remote.WeathersRemoteDataSourceImp
import com.dallmeier.data.source.remote.base.ApiService
import com.dallmeier.domain.repository.WeatherRepository
import com.dallmeier.domain.usecase.GetWeatherUseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun createGetWeatherUseCase(weatherRepository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(weatherRepository)
    }

    @Provides
    @Singleton
    fun createWeatherRepository(
        photosRemoteDataSource: WeathersRemoteDataSource,
        photosLocalDataSource: WeathersLocalDataSource,
        gson: Gson
    ): WeatherRepository {
        return WeathersRepositoryImp(photosRemoteDataSource, photosLocalDataSource, gson)
    }

    @Provides
    @Singleton
    fun createWeathersRemoteDataSource(apiService: ApiService): WeathersRemoteDataSource {
        return WeathersRemoteDataSourceImp(apiService)
    }

    @Provides
    @Singleton
    fun createWeathersLocalDataSource(appDatabase: AppDatabase): WeathersLocalDataSource {
        return WeathersLocalDataSourceImp(appDatabase)
    }

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob())
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope