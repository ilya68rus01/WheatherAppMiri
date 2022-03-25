package khrushchev.ilya.wheatherapp

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import khrushchev.ilya.wheatherapp.databinding.Item2WeatherBinding
import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import khrushchev.ilya.wheatherapp.models.ListWheatherModel
import khrushchev.ilya.wheatherapp.models.TimeWeatherModel
import java.text.SimpleDateFormat
import java.util.*

class SecondWeatherHolder(private val binding: Item2WeatherBinding) :
    RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        Item2WeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: TimeWeatherModel){
        val sdf = SimpleDateFormat("dd.MM.yyyy EEEE HH:mm:ss", Locale("ru"))
        binding.dataItemFrag2.text = sdf.format(item.date2)
        binding.tempItemFrag2.text = binding.root.context.getString(R.string.gradus, item.temp2)
        Picasso.get()
            .load("https://openweathermap.org/img/wn/" + item.icon2 + "@2x.png")
            .into(binding.imageItemFrag2)
    }

}