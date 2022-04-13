package khrushchev.ilya.wheatherapp.repository

import android.util.Log
import khrushchev.ilya.wheatherapp.models.WheatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteWeatherRepositoryImpl(
    private val api: WheatherService
) : RemoteWeatherRepository {

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