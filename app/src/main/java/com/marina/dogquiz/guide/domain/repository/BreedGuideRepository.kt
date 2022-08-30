package com.marina.dogquiz.guide.domain.repository

import com.marina.dogquiz.guide.domain.entity.Breed
import com.marina.dogquiz.guide.domain.entity.BreedImage

interface BreedGuideRepository {

    suspend fun getBreedList(query: String): List<Breed>

    suspend fun getBreedImages(breed: String): List<BreedImage>
}