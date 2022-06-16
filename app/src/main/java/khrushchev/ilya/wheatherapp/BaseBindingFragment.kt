package khrushchev.ilya.wheatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

open class BaseBindingFragment<T : ViewBinding>(
    val callback: (
        LayoutInflater,
        ViewGroup?,
        Boolean
    ) -> T
) : Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding ?: throw NullPointerException("Not initialized")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = callback(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}