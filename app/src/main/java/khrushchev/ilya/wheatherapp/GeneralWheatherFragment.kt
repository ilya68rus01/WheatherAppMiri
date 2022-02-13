package khrushchev.ilya.wheatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khrushchev.ilya.wheatherapp.databinding.FragmentGeneralWheatherBinding
import khrushchev.ilya.wheatherapp.models.WheatherModel
import khrushchev.ilya.wheatherapp.repository.FunResponse
import khrushchev.ilya.wheatherapp.repository.RepositoryResponse
import java.lang.NullPointerException

class GeneralWheatherFragment : Fragment() {

    private var _binding: FragmentGeneralWheatherBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Not initialized")

    private lateinit var repository: FunResponse
    private lateinit var adapter: WheatherAdapter

    private fun repositoryCallback(wheather: WheatherModel){
        adapter.setLists(wheather.list)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralWheatherBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        repository = RepositoryResponse()
        adapter = WheatherAdapter()
        binding.recycler.adapter = adapter
        repository.apiModel(this::repositoryCallback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
