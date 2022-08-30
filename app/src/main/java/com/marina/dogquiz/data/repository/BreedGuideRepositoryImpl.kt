package com.marina.dogquiz.data.repository

import com.marina.dogquiz.data.mapper.BreedMapper
import com.marina.dogquiz.data.mapper.ImageMapper
import com.marina.dogquiz.data.storage.remote.RetrofitInstance
import com.marina.dogquiz.domain.entity.Breed
import com.marina.dogquiz.domain.entity.BreedImage
import com.marina.dogquiz.domain.repository.BreedGuideRepository

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