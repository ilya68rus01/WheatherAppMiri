package khrushchev.ilya.wheatherapp.models

import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

fun List<ListWheatherModel>.mapToModel():List<TimeWeatherModel>{
    var currentDay = Date()
    return map {
        val sdft = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date2 = sdft.parse(it.dt_txt)
        val temp2 = (it.mainWeather.temp - 273f).toInt()
        val icon2 = it.weather.first().icon
        TimeWeatherModel(date2, temp2, icon2)
    }
        .filterIndexed { index, pohu ->
            if (index==0){
                currentDay = pohu.date2
                true
            } else if (pohu.date2.after(currentDay)){
                currentDay = pohu.date2
                true
            }else false
        }
}