package com.dallmeier.presentation.weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dallmeier.presentation.base.BaseViewModel
import com.dallmeier.domain.base.UseCaseResponse
import com.dallmeier.domain.model.WeatherEntity
import com.dallmeier.domain.usecase.GetWeatherUseCase
import com.dallmeier.presentation.model.Weather
import com.dallmeier.presentation.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class WeatherViewModel @Inject constructor (
    weatherUseCase: GetWeatherUseCase) : BaseViewModel() {
    var photosData = MutableLiveData<List<Weather>>()
    var weatherUseCase = weatherUseCase;

    fun getWeathers(isNetworkAvailable : Boolean){
        showLoadingProgressBar()
        weatherUseCase.invoke(viewModelScope, isNetworkAvailable, object :
            UseCaseResponse<List<WeatherEntity>?> {
            override fun onSuccess(result: List<WeatherEntity>?) {
                Log.d(TAG, "onSuccess() called with: result = ${result?.size}")
                hideLoadingProgressBar()
                photosData.value = result?.map {
                    it.toUI()
                }
            }

            override fun onError(throwable: Throwable) {
                Log.d(TAG, "onError() called with: error = ${throwable.message}")
                hideLoadingProgressBar()
            }
        })
    }

    companion object{
        private const val TAG = "PhotosViewModel"
    }
}