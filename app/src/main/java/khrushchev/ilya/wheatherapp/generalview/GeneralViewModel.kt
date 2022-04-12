package khrushchev.ilya.wheatherapp.generalview

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

        _hourWheatherModel.tryEmit(hourWheatherModel)
    }
}