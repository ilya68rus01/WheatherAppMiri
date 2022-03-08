package khrushchev.ilya.wheatherapp

import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import khrushchev.ilya.wheatherapp.models.ListWheatherModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import java.util.*

fun List<ListWheatherModel>.mapToDisplayableModel():List<DailyWeatherModel>{
    var currentDay = Date()
    return this.map {

        val sdft = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = sdft.parse(it.dt_txt)

        val description = it.weather.first().description
        val wind = it.wind.speed.toInt()
        val pressure = it.mainWeather.pressure
        val temp = (it.mainWeather.temp - 273f).toInt()
        val icon = it.weather.first().icon
        DailyWeatherModel(date, description, wind, pressure, temp, icon)
    }
        .filterIndexed { index, dailyWeatherModel ->
            if (index==0){
                currentDay = dailyWeatherModel.date
                true
            } else if (dailyWeatherModel.date.after(currentDay)){
                currentDay = dailyWeatherModel.date
                true
            }else false
        }
}
