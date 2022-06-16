package khrushchev.ilya.wheatherapp.repository

import khrushchev.ilya.wheatherapp.models.WheatherModel

interface RemoteWeatherRepository {
    fun requestWeather(lat: Double, lon: Double, callback: (WheatherModel)->Unit)
}