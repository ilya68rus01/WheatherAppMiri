package khrushchev.ilya.wheatherapp

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import khrushchev.ilya.wheatherapp.databinding.ActivityMainBinding
import khrushchev.ilya.wheatherapp.generalview.GeneralWheatherFragment
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    var _binding: ActivityMainBinding? = null
    val binding get() = _binding ?: throw NullPointerException("Not initialized")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragManager = supportFragmentManager.beginTransaction()
        fragManager.add(binding.fragmentCont.id, GeneralWheatherFragment())

            .commit()

    }

    fun getComponent() = (application as App).appComponent

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}