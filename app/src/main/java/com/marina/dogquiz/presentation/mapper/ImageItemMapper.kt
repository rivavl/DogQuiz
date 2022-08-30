package com.marina.dogquiz.presentation.mapper

import com.marina.dogquiz.domain.entity.Breed
import com.marina.dogquiz.domain.entity.BreedImage
import com.marina.dogquiz.presentation.entity.BreedItem
import com.marina.dogquiz.presentation.entity.ImageItem

object ImageItemMapper {
    fun mapEntityToUiItem(entity: BreedImage): ImageItem {
        return ImageItem(entity.url)
    }

    fun mapListEntitiesToUiItems(list: List<BreedImage>): List<ImageItem> {
        return list.map { mapEntityToUiItem(it) }
    }
}