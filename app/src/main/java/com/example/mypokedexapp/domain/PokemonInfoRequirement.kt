package com.example.mypokedexapp.domain

import com.example.mypokedexapp.data.PokemonRepository
import com.example.mypokedexapp.data.network.model.pokemon.Pokemon

//  intenta hacer la implementación de PokemonInfoRequirement
//  y revisa con el resultado que sea el adecuado.
//  Recuerda que el info no lo hacemos desde el ViewModel
//  sino desde el ViewHolder del RecyclerView

class PokemonInfoRequirement {
    private val repository = PokemonRepository()

    suspend operator fun invoke(
        numberPokemon:Int
    ): Pokemon? = repository.getPokemonInfo(numberPokemon)
}