package khrushchev.ilya.wheatherapp

import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import khrushchev.ilya.wheatherapp.models.ListWheatherModel
import khrushchev.ilya.wheatherapp.models.mapToModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import java.util.*

fun List<ListWheatherModel>.mapToDisplayableModel(): List<DailyWeatherModel> {
    var currentDay = Date()
    return this.filterIndexed { index, listWeatherModel ->
        val sdft = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = sdft.parse(listWeatherModel.dt_txt)
        if (index == 0) {
            currentDay = date
            true
        } else if (date.after(currentDay)) {
            currentDay = date
            true
        } else false
    }
        .map {
            val sdft = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = sdft.parse(it.dt_txt)

            val description = it.weather.first().description
            val wind = it.wind.speed.toInt()
            val pressure = it.mainWeather.pressure
            val temp = (it.mainWeather.temp - 273f).toInt()
            val icon = it.weather.first().icon
            val weatherLists = this.mapToModel(date)
            DailyWeatherModel(date, description, wind, pressure, temp, icon, weatherLists)
        }

}
