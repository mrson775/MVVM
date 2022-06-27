package com.dallmeier.domain.usecase

import com.dallmeier.domain.base.SingleUseCase
import com.dallmeier.domain.model.WeatherEntity
import com.dallmeier.domain.repository.WeatherRepository
import javax.inject.Inject


class GetWeatherUseCase  @Inject constructor (
    weatherRepository: WeatherRepository) :
    SingleUseCase<List<WeatherEntity>?, Boolean>() {
    private val weatherRepository = weatherRepository

    override suspend fun run(params: Boolean?): List<WeatherEntity>? {
      return  weatherRepository.getWeatherList(true)
    }
}