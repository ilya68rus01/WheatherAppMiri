package khrushchev.ilya.wheatherapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import khrushchev.ilya.wheatherapp.models.TimeWeatherModel

class SecondWeatherAdapter(): RecyclerView.Adapter<SecondWeatherHolder>() {

    val secondList: MutableList<TimeWeatherModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SecondWeatherHolder(parent)

    override fun onBindViewHolder(holder: SecondWeatherHolder, position: Int) {
        holder.populate(secondList[position])
    }

    override fun getItemCount() = secondList.size

    fun setSecondLists(getList: List<TimeWeatherModel>){
        secondList.addAll(getList)
        notifyDataSetChanged()
    }

}