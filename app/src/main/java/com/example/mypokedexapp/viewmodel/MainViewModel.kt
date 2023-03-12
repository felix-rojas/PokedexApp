package com.example.mypokedexapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedexapp.data.network.model.PokedexObject
import com.example.mypokedexapp.domain.PokemonListRequirement
import com.example.mypokedexapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val pokedexObjectLiveData = MutableLiveData<com.example.mypokedexapp.data.network.model.PokedexObject?>()
    private val pokemonListRequirement = PokemonListRequirement()
    fun getPokemonList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: PokedexObject? = pokemonListRequirement(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                pokedexObjectLiveData.postValue(result)
            }
        }}
}