package com.dallmeier.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dallmeier.domain.model.WeatherEntity
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


@JsonClass(generateAdapter = true)
@Entity
data class WeatherResponse(
    var timepoint: Int,
    @PrimaryKey(autoGenerate = true) var id: Int,
    var cloudcover: Int,
    var url: Int,
    var transparency: Int,
    var lifted_index: Int
) {

    fun toDomain(): WeatherEntity =
        WeatherEntity(
            timepoint = timepoint,
            id = id,
            cloudcover = cloudcover,
            lifted_index = lifted_index,
            transparency = transparency
        )
}

