package com.marina.dogquiz.guess_breed.data.remote.api

import com.marina.dogquiz.guess_breed.data.remote.dto.BreedResponse
import com.marina.dogquiz.guess_breed.data.remote.dto.RandomImageResponse
import retrofit2.http.GET

interface GameService {
    @GET("breeds/list")
    suspend fun getAllBreeds(): BreedResponse

    @GET("breeds/image/random")
    suspend fun getRandomImage(): RandomImageResponse
}