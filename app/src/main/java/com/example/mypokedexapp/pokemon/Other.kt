package com.example.mypokedexapp.pokemon

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName ("dream_world") val dream_world: DreamWorld,
    val home: Home,
    @SerializedName ("official-artwork") val official_artwork: OfficialArtwork
)