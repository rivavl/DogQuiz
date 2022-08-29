package com.marina.dogquiz.data.storage.remote

import retrofit2.http.GET

interface DogService {
    @GET("breeds/list")
    suspend fun getAllBreeds(): DogResponse
}