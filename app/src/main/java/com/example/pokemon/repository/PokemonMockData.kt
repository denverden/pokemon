package com.example.pokemon.repository

import com.example.pokemon.R
import com.example.pokemon.model.Pokemon

object PokemonMockData {
    private val pokemons = listOf(
        Pokemon(0, "Charmander", 6, 85, listOf("Fire"), R.drawable.charmander, "#FD7D24"),
        Pokemon(1, "Pikachu", 4, 60, listOf("Electric"), R.drawable.pikachu, "#E0B330"),
        Pokemon(2, "Blastoise", 16, 855, listOf("Water"), R.drawable.blastoise, "#4592C4")
    ).associateBy { it.id }

    fun getPokemons(): List<Pokemon> {
        return pokemons.values.toList()
    }
    fun getPokemonById(id: Int): Pokemon? {
        return pokemons[id]
    }
}