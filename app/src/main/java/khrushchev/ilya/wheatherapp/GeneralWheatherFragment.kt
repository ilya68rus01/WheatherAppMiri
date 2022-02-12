package khrushchev.ilya.wheatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import khrushchev.ilya.wheatherapp.databinding.FragmentGeneralWheatherBinding
import java.lang.NullPointerException

class GeneralWheatherFragment : Fragment() {

    var _binding: FragmentGeneralWheatherBinding? = null
    val binding get() = _binding ?: throw NullPointerException("Not initialized")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralWheatherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
