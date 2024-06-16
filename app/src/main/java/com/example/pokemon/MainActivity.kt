package com.example.pokemon

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.model.Pokemon

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            Pokemon(4, "Charmander", 6, 85, listOf("Fire"), R.drawable.charmander, "#FD7D24"),
            Pokemon(25, "Pikachu", 4, 60, listOf("Electric"), R.drawable.pikachu, "#E0B330"),
            Pokemon(9, "Blastoise", 16, 855, listOf("Water"), R.drawable.blastoise, "#4592C4"),
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items.map { it.name })

        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("position", position)
            this.startActivity(intent)
        }
    }
}