package khrushchev.ilya.wheatherapp


import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import khrushchev.ilya.wheatherapp.databinding.ItemWheatherBinding
import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import java.text.SimpleDateFormat
import java.util.*

class DayliWeatherHolder(private val binding: ItemWheatherBinding) :
    RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemWheatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: DailyWeatherModel, callback: (DailyWeatherModel) -> Unit) {

        val sdf = SimpleDateFormat("dd.MM.yyyy EEEE", Locale("ru"))
        binding.date.text = sdf.format(item.date)
        binding.description.text = item.description
        binding.wind.text = binding.root.context.getString(R.string.veter, item.wind)
        binding.pressure.text = binding.root.context.getString(R.string.pox, item.pressure)
        binding.temp.text = binding.root.context.getString(R.string.gradus, item.temp)
        Picasso.get()
            .load("https://openweathermap.org/img/wn/" + item.icon + "@2x.png")
            .into(binding.img)

        binding.root.setOnClickListener {
            callback(item)
        }

    }



}