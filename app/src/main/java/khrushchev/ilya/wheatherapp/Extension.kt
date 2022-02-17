package khrushchev.ilya.wheatherapp

import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import khrushchev.ilya.wheatherapp.models.ListWheatherModel

fun List<ListWheatherModel>.mapToDisplayableModel() =
    this.map {
        val date = it.dt_txt
        val description = it.weather.first().description
        val wind = it.wind.speed
        val pressure = it.mainWeather.pressure
        val temp = (it.mainWeather.temp - 273f).toInt()
        val icon = it.weather.first().icon
        DailyWeatherModel(date, description, wind, pressure, temp, icon)
    }