package khrushchev.ilya.wheatherapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

import java.util.*

@Parcelize
data class TimeWeatherModel(
    var date2: Date,
    val temp2: Int,
    val icon2: String
) : Parcelable
