package khrushchev.ilya.wheatherapp.models

import com.google.gson.annotations.SerializedName

data class MainWheather(
    @SerializedName("temp")
    val temp: Int,
    @SerializedName("feels_like")
    val feelsLike: Float,
    @SerializedName("tem")
    val temp_min: Float,
    @SerializedName("temp_max")
    val temp_max: Int,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("sea_level")
    val sea_level: Int,
    @SerializedName("grnd_level")
    val grnd_level: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("temp_kf")
    val temp_kf: Float
)
