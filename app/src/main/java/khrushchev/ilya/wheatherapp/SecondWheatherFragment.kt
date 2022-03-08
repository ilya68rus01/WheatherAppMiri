package khrushchev.ilya.wheatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import khrushchev.ilya.wheatherapp.databinding.FragmentSecondWheatherBinding
import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import khrushchev.ilya.wheatherapp.models.WheatherModel
import khrushchev.ilya.wheatherapp.models.mapToModel
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepositoryImpl
import java.lang.NullPointerException


class SecondWheatherFragment : Fragment() {

    var _binding: FragmentSecondWheatherBinding? = null
    val binding get() = _binding ?: throw NullPointerException("Not initialized")

    val adapter: SecondWeatherAdapter = SecondWeatherAdapter()
    val repository: RemoteWeatherRepository = RemoteWeatherRepositoryImpl()

    private fun repositoryCallback(wheather: WheatherModel) {
        adapter.setSecondLists(wheather.list.mapToModel())
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
        repository.requestWeather(this::repositoryCallback)
        binding.recycler2.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}