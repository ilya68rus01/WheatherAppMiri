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

class SecondWheatherFragment : Fragment() {

    var _binding: FragmentSecondWheatherBinding? = null
    val binding get() = _binding ?: throw NullPointerException("Not initialized")

    val adapter: SecondWeatherAdapter = SecondWeatherAdapter()

    companion object {

        fun newInstance(hourWheatherModel: List<TimeWeatherModel>): SecondWheatherFragment {
            return SecondWheatherFragment().apply {
                arguments = bundleOf(GeneralWheatherFragment.KEY_FOR_DATA to hourWheatherModel)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondWheatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val dataForScreen =
            arguments?.getParcelableArrayList<TimeWeatherModel>(GeneralWheatherFragment.KEY_FOR_DATA)
                ?.toList() ?: emptyList()
        binding.recycler2.adapter = adapter
        adapter.setSecondLists(dataForScreen)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}