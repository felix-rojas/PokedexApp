package com.example.mypokedexapp.views

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypokedexapp.utils.Constants
import com.example.mypokedexapp.adapters.PokemonAdapter
import com.example.mypokedexapp.databinding.ActivityMainBinding
import com.example.mypokedexapp.data.network.model.PokedexObject
import com.example.mypokedexapp.data.network.model.PokemonBase
import com.example.mypokedexapp.data.PokemonRepository
import com.example.mypokedexapp.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//activity - layout connection

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data:ArrayList<com.example.mypokedexapp.data.network.model.PokemonBase>

    private val viewModel: MainViewModel by viewModels()

    // instance the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()
        initializeObservers()
        viewModel.getPokemonList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){
        viewModel.pokedexObjectLiveData.observe(this){ pokedexObject ->
            if (pokedexObject != null) {
                setUpRecyclerView(pokedexObject.results)
            }
        }
    }
//    private fun testData():ArrayList<com.example.mypokedexapp.data.network.model.PokemonBase>{
//        var result = ArrayList<com.example.mypokedexapp.data.network.model.PokemonBase>()
//
//        result.add(com.example.mypokedexapp.data.network.model.PokemonBase("bulbasaur", ""))
//        result.add(com.example.mypokedexapp.data.network.model.PokemonBase("charmander", ""))
//        result.add(com.example.mypokedexapp.data.network.model.PokemonBase("squirtle", ""))
//
//        return result
//    }

    private fun setUpRecyclerView(dataForList:ArrayList<com.example.mypokedexapp.data.network.model.PokemonBase>){
        binding.RVPokemon.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVPokemon.layoutManager = linearLayoutManager
        adapter.PokemonAdapter(dataForList,this)
        binding.RVPokemon.adapter = adapter
    }

    private fun getPokemonList(){
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonRepository = PokemonRepository()
            val result: com.example.mypokedexapp.data.network.model.PokedexObject? = pokemonRepository.getPokemonList(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                setUpRecyclerView(result?.results!!)
            }
        }}

}