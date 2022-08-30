package com.marina.dogquiz.guide.domain.use_case

import com.marina.dogquiz.guide.domain.entity.Breed
import com.marina.dogquiz.guide.domain.repository.BreedGuideRepository

class GetBreedsUseCase(private val repository: BreedGuideRepository) {
    suspend operator fun invoke(query: String): List<Breed> {
        return repository.getBreedList(query)
    }
}