package com.marina.dogquiz.domain.use_case

import com.marina.dogquiz.domain.entity.Breed
import com.marina.dogquiz.domain.repository.BreedGuideRepository

class GetBreedsUseCase(private val repository: BreedGuideRepository) {
    suspend operator fun invoke(query: String): List<Breed> {
        return repository.getBreedList(query)
    }
}