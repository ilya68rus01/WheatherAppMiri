package khrushchev.ilya.wheatherapp.models

data class DailyWeatherModel(
    val date: String,
    val description: String,
    val wind: Float,
    val pressure: Int,
    val temp: Float,
    val icon: String
)
