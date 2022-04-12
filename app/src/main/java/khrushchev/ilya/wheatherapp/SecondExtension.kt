package khrushchev.ilya.wheatherapp.models

import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

fun List<ListWheatherModel>.mapToModel(): List<TimeWeatherModel> {

    return this
        .map {
        val sdft = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date2 = sdft.parse(it.dt_txt)
        val temp2 = (it.mainWeather.temp - 273f).toInt()
        val icon2 = it.weather.first().icon
        TimeWeatherModel(date2, temp2, icon2)
    }
}