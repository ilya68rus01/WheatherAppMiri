package khrushchev.ilya.wheatherapp.repository

import android.util.Log
import khrushchev.ilya.wheatherapp.WheatherService
import khrushchev.ilya.wheatherapp.models.WheatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteWeatherRepositoryImpl : RemoteWeatherRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: WheatherService = retrofit.create(WheatherService::class.java)

    override fun requestWeather(callback: (WheatherModel) -> Unit) {

        val responseCallback = object : Callback<WheatherModel> {
            override fun onResponse(call: Call<WheatherModel>, response: Response<WheatherModel>) {
                response.body()?.let { callback(it) }
            }

            override fun onFailure(call: Call<WheatherModel>, t: Throwable) {
                Log.e("error", t.toString())
            }
        }

        api.getApi().enqueue(responseCallback)
    }

}