package com.dallmeier.domain.model

data class WeatherEntity(
    var id: Int,
    var timepoint: Int,
    var cloudcover: Int,
    var transparency: Int,
    var lifted_index: Int
)