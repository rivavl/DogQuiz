package com.marina.dogquiz.presentation.mapper

import com.marina.dogquiz.domain.entity.Breed
import com.marina.dogquiz.presentation.entity.BreedItem

object BreedItemMapper {
    fun mapEntityToUiItem(entity: Breed): BreedItem {
        return BreedItem(entity.name)
    }

    fun mapListEntitiesToUiItems(list: List<Breed>): List<BreedItem> {
        return list.map { mapEntityToUiItem(it) }
    }
}