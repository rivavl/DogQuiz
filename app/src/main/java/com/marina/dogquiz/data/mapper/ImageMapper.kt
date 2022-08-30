package com.marina.dogquiz.data.mapper

import com.marina.dogquiz.domain.entity.Breed
import com.marina.dogquiz.domain.entity.BreedImage

object ImageMapper {
    fun mapListToBreedImage(list: List<String>): List<BreedImage> {
        return list.map {
            BreedImage(it)
        }
    }
}