package khrushchev.ilya.wheatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import khrushchev.ilya.wheatherapp.databinding.FragmentGeneralWheatherBinding
import khrushchev.ilya.wheatherapp.models.DailyWeatherModel
import khrushchev.ilya.wheatherapp.models.WheatherModel
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepositoryImpl
import java.lang.NullPointerException


class GeneralWheatherFragment : Fragment() {

    val frag2 = SecondWheatherFragment()

    private var _binding: FragmentGeneralWheatherBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Not initialized")

    private var repository: RemoteWeatherRepository = RemoteWeatherRepositoryImpl()
    private var adapter: WheatherAdapter = WheatherAdapter(this::adapterCallback)

    private fun repositoryCallback(wheather: WheatherModel) {
        adapter.setLists(wheather.list.mapToDisplayableModel())
    }

    private fun adapterCallback(callback: DailyWeatherModel) {
        parentFragmentManager.beginTransaction()
            .add(R.id.fragment_Cont, frag2)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralWheatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.recycler.adapter = adapter
        repository.requestWeather(this::repositoryCallback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
