package khrushchev.ilya.wheatherapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import khrushchev.ilya.wheatherapp.databinding.ActivityMainBinding
import khrushchev.ilya.wheatherapp.databinding.ItemWheatherBinding

class ViewHolder(private val binding: ItemWheatherBinding) : RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemWheatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun populate(item: String) {
        binding.date.text = item
        binding.text.text = item
    }

}