package khrushchev.ilya.wheatherapp.models

import com.google.gson.annotations.SerializedName

data class Coordination(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)
