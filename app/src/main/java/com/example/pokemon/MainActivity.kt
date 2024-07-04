package com.example.pokemon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemon.customRecycleView.CustomAdapter
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.repository.PokemonMockData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            listView.adapter = CustomAdapter(PokemonMockData.getPokemons()) { id ->
                val intent = Intent(this@MainActivity, InfoActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }

            val divider = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            divider.setDrawable(ContextCompat.getDrawable(this@MainActivity, R.drawable.separator)!!)
            listView.addItemDecoration(divider)
        }
    }
}