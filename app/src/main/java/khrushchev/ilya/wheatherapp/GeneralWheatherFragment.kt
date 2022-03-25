package khrushchev.ilya.wheatherapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import khrushchev.ilya.wheatherapp.databinding.FragmentGeneralWheatherBinding
import khrushchev.ilya.wheatherapp.models.*
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepositoryImpl
import kotlinx.coroutines.flow.collect
import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.util.*

class GeneralWheatherFragment : Fragment() {

    private var _binding: FragmentGeneralWheatherBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Not initialized")

    private lateinit var viewModel: GeneralViewModel

    private lateinit var adapter: WheatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralWheatherBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GeneralViewModel::class.java)
        adapter = WheatherAdapter(viewModel::adapterCallback)

        viewModel.dailyWeatherModels.observe(viewLifecycleOwner) {
            adapter.setLists(it)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.hourWheatherModel.collect {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_Cont, SecondWheatherFragment.newInstance(it))
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        binding.recycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY_FOR_DATA = "key1"
    }
}
