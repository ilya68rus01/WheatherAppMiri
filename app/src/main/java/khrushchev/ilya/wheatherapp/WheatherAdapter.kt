package khrushchev.ilya.wheatherapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WheatherAdapter:RecyclerView.Adapter<ViewHolder>() {

    val list: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populate(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setLists(getList: List<String>){
        list.addAll(getList)
        notifyDataSetChanged()
    }

}