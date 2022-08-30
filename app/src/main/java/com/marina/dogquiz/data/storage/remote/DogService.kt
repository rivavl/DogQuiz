package com.marina.dogquiz.data.storage.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    @GET("breeds/list")
    suspend fun getAllBreeds(): DogResponse

    @GET("breed/{breedName}/images")
    suspend fun getBreedImages(@Path("breedName") breedName: String): ImageResponse
}