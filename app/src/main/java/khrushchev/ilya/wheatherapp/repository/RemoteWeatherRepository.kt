package khrushchev.ilya.wheatherapp.repository

import khrushchev.ilya.wheatherapp.models.WheatherModel

interface RemoteWeatherRepository {
    fun requestWeather(callback: (WheatherModel)->Unit)
}