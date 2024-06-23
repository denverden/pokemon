package com.example.pokemon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemon.customRecycleView.customAdapter
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.repository.PokemonMockData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.listView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter(PokemonMockData.getPokemons(), this)
    }
}