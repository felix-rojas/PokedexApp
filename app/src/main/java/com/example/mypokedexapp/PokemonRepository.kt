package com.example.mypokedexapp

import com.example.mypokedexapp.pokemon.Pokemon

class PokemonRepository() {
    private lateinit var api:PokemonAPIService

    suspend fun getPokemonList(limit:Int):PokedexObject?{
        //todo: Inicializar variable api
        return try{
            api.getPokemonList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getPokemonInfo(numberPokemon:Int): Pokemon? {
        //todo: Inicializar variable api
        return try{
            api.getPokemonInfo(numberPokemon)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}