package khrushchev.ilya.wheatherapp.generalview

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import khrushchev.ilya.wheatherapp.*
import khrushchev.ilya.wheatherapp.databinding.FragmentGeneralWheatherBinding
import khrushchev.ilya.wheatherapp.di.modules.ViewModelProviderFactory
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

open class GeneralWheatherFragment :
    FetchLocation<FragmentGeneralWheatherBinding>(FragmentGeneralWheatherBinding::inflate) {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory
    lateinit var viewModel: GeneralViewModel

    private lateinit var adapter: WheatherAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).getComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestLocation { viewModel.getWeather(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(GeneralViewModel::class.java)

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

    companion object {
        const val KEY_FOR_DATA = "key1"
    }
}
