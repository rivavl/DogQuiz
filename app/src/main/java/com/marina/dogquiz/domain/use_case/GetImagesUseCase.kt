package com.marina.dogquiz.domain.use_case

import com.marina.dogquiz.domain.entity.BreedImage
import com.marina.dogquiz.domain.repository.BreedGuideRepository

class GetImagesUseCase(private val repository: BreedGuideRepository) {
    suspend operator fun invoke(breed: String): List<BreedImage> {
        return repository.getBreedImages(breed)
    }
}