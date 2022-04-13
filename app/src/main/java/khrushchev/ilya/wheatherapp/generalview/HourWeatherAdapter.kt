package khrushchev.ilya.wheatherapp.generalview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import khrushchev.ilya.wheatherapp.models.TimeWeatherModel

class HourWeatherAdapter: RecyclerView.Adapter<HourWeatherHolder>() {

    val list: MutableList<TimeWeatherModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HourWeatherHolder(parent)

    override fun onBindViewHolder(holder: HourWeatherHolder, position: Int) {
        holder.populate(list[position])
    }

    override fun getItemCount() = list.size

    fun setData(getLists: List<TimeWeatherModel>){
        list.addAll(getLists)
        notifyDataSetChanged()
    }
}