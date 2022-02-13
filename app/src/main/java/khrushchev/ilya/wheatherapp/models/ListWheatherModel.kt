package khrushchev.ilya.wheatherapp.models

import com.google.gson.annotations.SerializedName

data class ListWheatherModel(
    @SerializedName("dt")
    val dt: Int,
    val visibility: Int,
    val pop: Int,
    val dt_txt: String
)
