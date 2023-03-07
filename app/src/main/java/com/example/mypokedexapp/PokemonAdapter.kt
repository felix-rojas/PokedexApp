package com.example.mypokedexapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokedexapp.databinding.ItemPokemonBinding


class PokemonAdapter: RecyclerView.Adapter<PokemonViewHolder>() {
    var data:ArrayList<PokemonBase> = ArrayList()

    fun PokemonAdapter(basicData : ArrayList<PokemonBase>){
        this.data = basicData
    }
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokemonViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}
