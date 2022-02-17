package khrushchev.ilya.wheatherapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import khrushchev.ilya.wheatherapp.databinding.ActivityMainBinding
import khrushchev.ilya.wheatherapp.databinding.ItemWheatherBinding
import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import khrushchev.ilya.wheatherapp.models.ListWheatherModel
import khrushchev.ilya.wheatherapp.models.WheatherInfo

class DayliWeatherHolder(private val binding: ItemWheatherBinding) : RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemWheatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: DailyWeatherModel) {
        binding.date.text = item.date
        binding.description.text = item.description
        binding.wind.text = item.wind.toString()
        binding.pressure.text = item.pressure.toString()
        binding.temp.text = item.temp.toString()
        Picasso.get()
            .load("https://openweathermap.org/img/wn/"+item.icon+"@2x.png")
            .into(binding.img)
    }

}