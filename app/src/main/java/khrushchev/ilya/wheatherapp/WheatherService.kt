package khrushchev.ilya.wheatherapp

import khrushchev.ilya.wheatherapp.models.WheatherModel
import retrofit2.Call
import retrofit2.http.GET

interface WheatherService {

    @GET("forecast?lat=52&lon=41&appid=14c7c80e7bd2dc44e40ff204d54e80d9")

    fun getApi(): Call<WheatherModel>

}