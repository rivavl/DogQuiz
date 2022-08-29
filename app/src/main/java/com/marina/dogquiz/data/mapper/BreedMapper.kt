package com.marina.dogquiz.data.mapper

import com.marina.dogquiz.domain.entity.Breed

object BreedMapper {
    fun mapListToBreeds(list: List<String>): List<Breed> {
        return list.map {
            Breed(it)
        }
    }
}