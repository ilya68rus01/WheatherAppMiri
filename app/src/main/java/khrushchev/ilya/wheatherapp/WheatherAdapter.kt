package khrushchev.ilya.wheatherapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import khrushchev.ilya.wheatherapp.models.ListWheatherModel

class WheatherAdapter : RecyclerView.Adapter<DayliWeatherHolder>() {

    val list: MutableList<ListWheatherModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DayliWeatherHolder(parent)

    override fun onBindViewHolder(holder: DayliWeatherHolder, position: Int) {
        holder.populate(list[position])
    }

    override fun getItemCount() = list.size

    fun setLists(getList: List<ListWheatherModel>) {
        list.addAll(getList)
        notifyDataSetChanged()
    }

}