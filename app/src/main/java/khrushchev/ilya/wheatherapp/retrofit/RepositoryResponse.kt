package khrushchev.ilya.wheatherapp.retrofit

import android.util.Log
import khrushchev.ilya.wheatherapp.WheatherService
import khrushchev.ilya.wheatherapp.models.WheatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryResponse: FunResponse {

    private val retrofit = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: WheatherService = retrofit.create(WheatherService::class.java)

    private val repositoryCallback = object : Callback<WheatherModel>{
        override fun onResponse(call: Call<WheatherModel>, response: Response<WheatherModel>) {

        }

        override fun onFailure(call: Call<WheatherModel>, t: Throwable) {
            Log.e("error", t.toString())
        }
    }

    override fun apiModel() {
        api.getApi().enqueue(repositoryCallback)
    }

}