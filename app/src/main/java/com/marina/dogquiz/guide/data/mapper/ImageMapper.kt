package com.marina.dogquiz.guide.data.mapper

import com.marina.dogquiz.guide.domain.entity.BreedImage

object ImageMapper {
    fun mapListToBreedImage(list: List<String>): List<BreedImage> {
        return list.map {
            BreedImage(it)
        }
    }
}