package khrushchev.ilya.wheatherapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import khrushchev.ilya.wheatherapp.models.ListWheatherModel

class WheatherAdapter:RecyclerView.Adapter<ViewHolder>() {

    val list: MutableList<ListWheatherModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populate(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setLists(getList: List<ListWheatherModel>){
        list.addAll(getList)
        notifyDataSetChanged()
    }

}