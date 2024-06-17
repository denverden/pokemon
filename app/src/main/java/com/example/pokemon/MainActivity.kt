package com.example.pokemon

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if ( savedInstanceState == null ) {
            Log.d("MainActivity", "onCreate: активность создана впервые")
        } else {
            Log.d("MainActivity", "onCreate: активность создана")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart: активность стартовала")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume: активность стала видимой")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause: активность в паузе")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop: активность остановлена")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart: активность перезапущена")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy: активность уничтожена")
    }
}