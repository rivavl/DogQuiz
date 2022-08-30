package com.marina.dogquiz.domain.repository

import com.marina.dogquiz.domain.entity.Breed
import com.marina.dogquiz.domain.entity.BreedImage

interface BreedGuideRepository {

    suspend fun getBreedList(query: String): List<Breed>

    suspend fun getBreedImages(breed: String): List<BreedImage>
}