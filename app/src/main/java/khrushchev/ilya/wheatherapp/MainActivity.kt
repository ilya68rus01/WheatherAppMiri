package khrushchev.ilya.wheatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import khrushchev.ilya.wheatherapp.databinding.ActivityMainBinding
import java.lang.NullPointerException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    var _binding: ActivityMainBinding? = null
    val binding get() = _binding ?: throw NullPointerException("Not initialized")

    val frag1 = GeneralWheatherFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragManager = supportFragmentManager.beginTransaction()
        fragManager.add(binding.fragmentCont.id, frag1)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}