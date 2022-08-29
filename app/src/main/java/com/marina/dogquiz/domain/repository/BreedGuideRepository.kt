package com.marina.dogquiz.domain.repository

import com.marina.dogquiz.domain.entity.Breed

interface BreedGuideRepository {
    suspend fun getBreedList(query: String): List<Breed>
}