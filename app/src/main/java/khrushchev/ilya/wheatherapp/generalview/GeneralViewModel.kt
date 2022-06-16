package khrushchev.ilya.wheatherapp.generalview

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import khrushchev.ilya.wheatherapp.mapToDisplayableModel
import khrushchev.ilya.wheatherapp.models.*
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class GeneralViewModel @Inject constructor(
    private val repository: RemoteWeatherRepository
) : ViewModel() {

    private val models = mutableListOf<ListWheatherModel>()

    private var _dailyWeatherModels = MutableLiveData<List<DailyWeatherModel>>()
    val dailyWeatherModels: LiveData<List<DailyWeatherModel>> get() =  _dailyWeatherModels

    private var _hourWheatherModel = MutableSharedFlow<List<TimeWeatherModel>>(0,1,BufferOverflow.DROP_OLDEST)
    val hourWheatherModel get() =  _hourWheatherModel.asSharedFlow()

    private fun repositoryCallback(wheather: WheatherModel) {
        models.addAll(wheather.list)
        _dailyWeatherModels.postValue(wheather.list.mapToDisplayableModel())
    }

    fun adapterCallback(callback: DailyWeatherModel) {
        val hourWheatherModel = models.mapToModel(callback.date)
        _hourWheatherModel.tryEmit(hourWheatherModel)
    }

    fun getWeather(location: Location?) {
        location?.let {
            repository.requestWeather(it.latitude, it.longitude, this::repositoryCallback)
        }
    }
}