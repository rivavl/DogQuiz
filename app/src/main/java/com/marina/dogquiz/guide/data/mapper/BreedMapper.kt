package com.marina.dogquiz.guide.data.mapper

import com.marina.dogquiz.guide.domain.entity.Breed

object BreedMapper {
    fun mapListToBreeds(list: List<String>): List<Breed> {
        return list.map {
            Breed(it)
        }
    }
}