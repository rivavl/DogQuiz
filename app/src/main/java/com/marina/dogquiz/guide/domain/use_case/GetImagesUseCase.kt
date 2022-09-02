package com.marina.dogquiz.guide.domain.use_case

import com.marina.dogquiz.guide.domain.entity.BreedImage
import com.marina.dogquiz.guide.domain.repository.BreedGuideRepository

class GetImagesUseCase(private val repository: BreedGuideRepository) {
    suspend operator fun invoke(breed: String): List<BreedImage> {
        return repository.getBreedImages(breed)
    }
}