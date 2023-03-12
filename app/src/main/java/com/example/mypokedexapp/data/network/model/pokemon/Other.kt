package com.example.mypokedexapp.data.network.model.pokemon

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName ("dream_world") val dream_world: com.example.mypokedexapp.data.network.model.pokemon.DreamWorld,
    val home: com.example.mypokedexapp.data.network.model.pokemon.Home,
    @SerializedName ("official-artwork") val official_artwork: com.example.mypokedexapp.data.network.model.pokemon.OfficialArtwork
)