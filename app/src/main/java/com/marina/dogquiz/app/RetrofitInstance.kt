package com.marina.dogquiz.app

import com.marina.dogquiz.guess_breed.data.remote.api.GameService
import com.marina.dogquiz.guide.data.storage.remote.DogService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {
    companion object {

        private const val BASE_URL = "https://dog.ceo/api/"

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val dogService by lazy {
            retrofit.create(DogService::class.java)
        }

        val gameService by lazy {
            retrofit.create(GameService::class.java)
        }
    }
}