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
import khrushchev.ilya.wheatherapp.models.*
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepositoryImpl
import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.util.*

class GeneralWheatherFragment : Fragment() {

    private var _binding: FragmentGeneralWheatherBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Not initialized")

    private var repository: RemoteWeatherRepository = RemoteWeatherRepositoryImpl()
    private var adapter: WheatherAdapter = WheatherAdapter(this::adapterCallback)

    private val models = mutableListOf<ListWheatherModel>()

    private fun repositoryCallback(wheather: WheatherModel) {
        models.addAll(wheather.list)
        adapter.setLists(wheather.list.mapToDisplayableModel())
    }

    private fun adapterCallback(callback: DailyWeatherModel) {

        val hourWheatherModel = models.filter {
            val sdft = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val date = sdft.parse(it.dt_txt)

            val sdf = SimpleDateFormat("dd", Locale.getDefault())
            val day = sdf.format(date)

            val clickedDay = sdf.format(callback.date)

            day == clickedDay
        }.mapToModel()

        parentFragmentManager.beginTransaction()
            .add(R.id.fragment_Cont, SecondWheatherFragment.newInstance(hourWheatherModel))
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

    companion object {
        const val KEY_FOR_DATA = "key1"
    }
}
