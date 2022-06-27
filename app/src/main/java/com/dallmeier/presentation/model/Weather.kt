package com.dallmeier.presentation.model

import android.os.Parcelable
import com.dallmeier.domain.model.WeatherEntity
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Weather(
    var id: Int,
    var timepoint: Int,
    var cloudcover: Int,
    var transparency: Int,
    var lifted_index: Int) : Parcelable

fun WeatherEntity.toUI() : Weather = Weather(
    id = id,
    timepoint = timepoint,
    cloudcover = cloudcover,
    transparency = transparency,
    lifted_index = lifted_index
)