package khrushchev.ilya.wheatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import khrushchev.ilya.wheatherapp.databinding.FragmentSecondWheatherBinding
import khrushchev.ilya.wheatherapp.generalview.GeneralWheatherFragment
import khrushchev.ilya.wheatherapp.models.*
import java.lang.NullPointerException
import java.util.*

class SecondWheatherFragment : BaseBindingFragment<FragmentSecondWheatherBinding>(FragmentSecondWheatherBinding::inflate) {

    val adapter: SecondWeatherAdapter = SecondWeatherAdapter()

    companion object {

        fun newInstance(hourWheatherModel: List<TimeWeatherModel>): SecondWheatherFragment {
            return SecondWheatherFragment().apply {
                arguments = bundleOf(GeneralWheatherFragment.KEY_FOR_DATA to hourWheatherModel)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val dataForScreen =
            arguments?.getParcelableArrayList<TimeWeatherModel>(GeneralWheatherFragment.KEY_FOR_DATA)
                ?.toList() ?: emptyList()
        binding.recycler2.adapter = adapter
        adapter.setSecondLists(dataForScreen)

    }

}