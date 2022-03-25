package khrushchev.ilya.wheatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import khrushchev.ilya.wheatherapp.models.*
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepositoryImpl
import java.text.SimpleDateFormat
import java.util.*

class GeneralViewModel : ViewModel() {

    private var repository: RemoteWeatherRepository = RemoteWeatherRepositoryImpl()
    private val models = mutableListOf<ListWheatherModel>()

    private var _dailyWeatherModels = MutableLiveData<List<DailyWeatherModel>>()
    val dailyWeatherModels: LiveData<List<DailyWeatherModel>> get() =  _dailyWeatherModels

    private var _hourWheatherModel = MutableLiveData< List<TimeWeatherModel>>()
    val hourWheatherModel: LiveData< List<TimeWeatherModel>> get() =  _hourWheatherModel

    init {
        repository.requestWeather(this::repositoryCallback)
    }

    private fun repositoryCallback(wheather: WheatherModel) {
        models.addAll(wheather.list)
        _dailyWeatherModels.postValue(wheather.list.mapToDisplayableModel())
    }

    fun adapterCallback(callback: DailyWeatherModel) {
        val hourWheatherModel = models.filter {
            val sdft = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val date = sdft.parse(it.dt_txt)

            val sdf = SimpleDateFormat("dd", Locale.getDefault())
            val day = sdf.format(date)

            val clickedDay = sdf.format(callback.date)

            day == clickedDay
        }.mapToModel()

        _hourWheatherModel.postValue(hourWheatherModel)
    }
}