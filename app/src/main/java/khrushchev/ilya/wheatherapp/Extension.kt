package khrushchev.ilya.wheatherapp


import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import khrushchev.ilya.wheatherapp.models.ListWheatherModel
import java.text.SimpleDateFormat
import java.util.*

fun List<ListWheatherModel>.mapToDisplayableModel() =
    this.map {

        val sdft = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = sdft.parse(it.dt_txt)
        val description = it.weather.first().description
        val wind = it.wind.speed.toInt()
        val pressure = it.mainWeather.pressure
        val temp = (it.mainWeather.temp - 273f).toInt()
        val icon = it.weather.first().icon
        DailyWeatherModel(date, description, wind, pressure, temp, icon)
    }
//        .filter {
//            it.date > "dd"
//        }

