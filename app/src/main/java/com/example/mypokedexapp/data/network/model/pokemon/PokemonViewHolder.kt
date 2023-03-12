package com.example.mypokedexapp.data.network.model.pokemon


import androidx.recyclerview.widget.RecyclerView
import com.example.mypokedexapp.data.network.model.PokemonBase
import com.example.mypokedexapp.databinding.ItemPokemonBinding

class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: com.example.mypokedexapp.data.network.model.PokemonBase){
        binding.TVName.text = item.name
    }
}