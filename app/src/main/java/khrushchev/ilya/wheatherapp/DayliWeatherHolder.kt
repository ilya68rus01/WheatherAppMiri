package khrushchev.ilya.wheatherapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import khrushchev.ilya.wheatherapp.databinding.ActivityMainBinding
import khrushchev.ilya.wheatherapp.databinding.ItemWheatherBinding
import khrushchev.ilya.wheatherapp.models.ListWheatherModel
import khrushchev.ilya.wheatherapp.models.WheatherInfo

class DayliWeatherHolder(private val binding: ItemWheatherBinding) : RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemWheatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: ListWheatherModel) {
        binding.date.text = item.dt_txt
        binding.description.text
    }

}