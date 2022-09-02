package com.marina.dogquiz.guide.data.repository

import com.marina.dogquiz.guide.data.mapper.BreedMapper
import com.marina.dogquiz.guide.data.mapper.ImageMapper
import com.marina.dogquiz.app.RetrofitInstance
import com.marina.dogquiz.guide.domain.entity.Breed
import com.marina.dogquiz.guide.domain.entity.BreedImage
import com.marina.dogquiz.guide.domain.repository.BreedGuideRepository

class BreedGuideRepositoryImpl : BreedGuideRepository {

    override suspend fun getBreedList(query: String): List<Breed> {
        return BreedMapper.mapListToBreeds(RetrofitInstance.dogService.getAllBreeds().message)
            .filter {
                it.name.contains(query)
            }
    }

    override suspend fun getBreedImages(breed: String): List<BreedImage> {
        val list = RetrofitInstance.dogService.getBreedImages(breed).message
        return ImageMapper.mapListToBreedImage(list)
    }
}