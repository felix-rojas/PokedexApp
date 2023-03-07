package com.example.mypokedexapp

object NetworkModuleDI {
    // convert calls to JSON
    private val gsonFactory:GsonConverterFactory = GsonConverterFactory.create()
    private val okHttpClient: OkHttpClient = OkHttpClient()

    operator fun invoke(): PokemonAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(APIService::class.java)
    }
}