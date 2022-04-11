package khrushchev.ilya.wheatherapp.generalview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import khrushchev.ilya.wheatherapp.R
import khrushchev.ilya.wheatherapp.databinding.ItemHorizontalBinding
import khrushchev.ilya.wheatherapp.models.TimeWeatherModel
import java.text.SimpleDateFormat
import java.util.*

class HourWeatherHolder(private val binding: ItemHorizontalBinding) :
    RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: TimeWeatherModel){

        val sdf = SimpleDateFormat("HH:mm", Locale("ru"))
        binding.time.text = sdf.format(item.date2)
        binding.temp.text = binding.root.context.getString(R.string.gradus, item.temp2)
        Picasso.get()
            .load("https://openweathermap.org/img/wn/" + item.icon2 + "@2x.png")
            .into(binding.image)
    }
}