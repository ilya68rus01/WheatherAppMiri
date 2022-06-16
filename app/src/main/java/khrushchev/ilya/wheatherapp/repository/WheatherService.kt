package khrushchev.ilya.wheatherapp.repository

import khrushchev.ilya.wheatherapp.models.WheatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WheatherService {
    @GET("forecast?appid=14c7c80e7bd2dc44e40ff204d54e80d9&lang=ru")
    fun getApi(@Query("lat") lat: Double, @Query("lon") lon: Double): Call<WheatherModel>
}