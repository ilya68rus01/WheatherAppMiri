package khrushchev.ilya.wheatherapp.generalview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import khrushchev.ilya.wheatherapp.models.DailyWeatherModel

class WheatherAdapter(private val callback: (DailyWeatherModel) -> Unit) : RecyclerView.Adapter<DayliWeatherHolder>() {

    val list: MutableList<DailyWeatherModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DayliWeatherHolder(parent)

    override fun onBindViewHolder(holder: DayliWeatherHolder, position: Int) {
        holder.populate(list[position], callback)
    }

    override fun getItemCount() = list.size

    fun setLists(getList: List<DailyWeatherModel>) {
        list.addAll(getList)
        notifyDataSetChanged()
    }

}