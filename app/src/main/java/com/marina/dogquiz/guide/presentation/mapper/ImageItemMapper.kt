package com.marina.dogquiz.guide.presentation.mapper

import com.marina.dogquiz.guide.domain.entity.BreedImage
import com.marina.dogquiz.guide.presentation.entity.ImageItem

object ImageItemMapper {
    fun mapEntityToUiItem(entity: BreedImage): ImageItem {
        return ImageItem(entity.url)
    }

    fun mapListEntitiesToUiItems(list: List<BreedImage>): List<ImageItem> {
        return list.map { mapEntityToUiItem(it) }
    }
}