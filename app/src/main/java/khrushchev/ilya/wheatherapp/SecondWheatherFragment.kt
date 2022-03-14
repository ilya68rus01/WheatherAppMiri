package khrushchev.ilya.wheatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import khrushchev.ilya.wheatherapp.databinding.FragmentSecondWheatherBinding
import khrushchev.ilya.wheatherapp.models.*
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepositoryImpl
import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.util.*

class SecondWheatherFragment : Fragment() {

    var _binding: FragmentSecondWheatherBinding? = null
    val binding get() = _binding ?: throw NullPointerException("Not initialized")

    val adapter: SecondWeatherAdapter = SecondWeatherAdapter()

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

        binding.recycler2.adapter = adapter
        setFragmentResultListener("key1") { key, result ->
            val model = result.getParcelableArrayList<TimeWeatherModel>("extra_key1")
            if (model != null) {
                adapter.setSecondLists(model.toList())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}