package com.example.pokemon

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = PokemonMockData.getPokemons()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items.map { it.name })

        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("position", position)
            this.startActivity(intent)
        }
    }
}