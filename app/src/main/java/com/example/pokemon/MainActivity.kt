package com.example.pokemon

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.test2.Pokemon

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            Pokemon(4, "Charmander", 6, 85, listOf("Fire"), "image"),
            Pokemon(25, "Pikachu", 4, 60, listOf("Electric"), "image"),
            Pokemon(9, "Blastoise", 16, 855, listOf("Water"), "image"),
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items.map { it.name })

        binding.listView.adapter = adapter
    }
}