package com.marina.dogquiz.guide.presentation.mapper

import com.marina.dogquiz.guide.domain.entity.Breed
import com.marina.dogquiz.guide.presentation.entity.BreedItem

object BreedItemMapper {
    fun mapEntityToUiItem(entity: Breed): BreedItem {
        return BreedItem(entity.name)
    }

    fun mapListEntitiesToUiItems(list: List<Breed>): List<BreedItem> {
        return list.map { mapEntityToUiItem(it) }
    }
}