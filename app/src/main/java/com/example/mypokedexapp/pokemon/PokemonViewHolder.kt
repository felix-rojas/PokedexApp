package com.example.mypokedexapp.pokemon


import androidx.recyclerview.widget.RecyclerView
import com.example.mypokedexapp.model.PokemonBase
import com.example.mypokedexapp.databinding.ItemPokemonBinding

class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PokemonBase){
        binding.TVName.text = item.name
    }
}