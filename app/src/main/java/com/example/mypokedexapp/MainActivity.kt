package com.example.mypokedexapp

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypokedexapp.PokemonAdapter
import com.example.mypokedexapp.PokemonBase
import com.example.mypokedexapp.databinding.ActivityMainBinding

//activity - layout connection

class MainActivity: Activity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data:ArrayList<PokemonBase>

    // instance the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()
        setUpRecyclerView(testData())
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    private fun testData():ArrayList<PokemonBase>{
        var result = ArrayList<PokemonBase>()

        result.add(PokemonBase("bulbasaur",""))
        result.add(PokemonBase("charmander",""))
        result.add(PokemonBase("squirtle",""))

        return result
    }

    private fun setUpRecyclerView(dataForList:ArrayList<PokemonBase>){
        binding.RVPokemon.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVPokemon.layoutManager = linearLayoutManager
        adapter.PokemonAdapter(dataForList)
        binding.RVPokemon.adapter = adapter
    }


}