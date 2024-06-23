package com.example.pokemon

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.databinding.ActivityInfoBinding
import com.example.pokemon.repository.PokemonMockData

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", -1)
        val pokemon = PokemonMockData.getPokemonById(id)
        val notFound = getString(R.string.not_found)
        val name = pokemon?.name ?: notFound
        val image = pokemon?.image ?: R.drawable.logo
        val color = Color.parseColor(pokemon?.color ?: "#FFFF2F2F")
        val type = getString(R.string.text_type, pokemon?.type?.joinToString(separator = ", ") ?: notFound)
        val height = getString(R.string.text_height, pokemon?.height ?: notFound)
        val weight = getString(R.string.text_weight, pokemon?.weight ?: notFound)

        with(binding) {
            pokemonName.text = name
            pokemonImage.setImageResource(image)
            pokemonType.text = type
            pokemonHeight.text = height
            pokemonWeight.text = weight
            info.setBackgroundColor(color)
            about.setTextColor(color)
            back.setOnClickListener {
                finish()
            }
        }
    }
}