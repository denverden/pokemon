package com.example.pokemon

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", -1)
        val pokemon = PokemonMockData.getPokemonPosition(position)

        if (position != -1 && pokemon != null) {
            val type = getString(R.string.text_type, pokemon.type.joinToString(separator = ", "))
            val height = getString(R.string.text_height, pokemon.height.toString())
            val weight = getString(R.string.text_weight, pokemon.weight.toString())
            binding.pokemonImage.setImageResource(pokemon.image)
            binding.info.setBackgroundColor(Color.parseColor(pokemon.color))
            binding.about.setTextColor(Color.parseColor(pokemon.color))
            binding.pokemonType.text = type
            binding.pokemonName.text = pokemon.name
            binding.pokemonHeight.text = height
            binding.pokemonWeight.text = weight
        } else {
            binding.pokemonImage.setImageResource(R.drawable.logo)
            binding.pokemonType.text = getString(R.string.not_found)
            binding.pokemonName.text = getString(R.string.not_found)
            binding.pokemonHeight.text = getString(R.string.not_found)
            binding.pokemonHeight.text = getString(R.string.not_found)
        }

        binding.back.setOnClickListener {
            finish()
        }
    }
}