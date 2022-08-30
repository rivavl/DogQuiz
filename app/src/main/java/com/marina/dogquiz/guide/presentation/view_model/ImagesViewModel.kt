package com.marina.dogquiz.guide.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marina.dogquiz.guide.domain.use_case.GetImagesUseCase
import com.marina.dogquiz.guide.presentation.entity.ImageItem
import com.marina.dogquiz.guide.presentation.mapper.ImageItemMapper
import kotlinx.coroutines.launch

class ImagesViewModel(
    private val getImagesUseCase: GetImagesUseCase
) : ViewModel() {

    private var _images = MutableLiveData<List<ImageItem>>()
    val images: LiveData<List<ImageItem>> get() = _images

    fun getImagesList(breed: String = "") {
        viewModelScope.launch {
            val list = getImagesUseCase(breed)
            _images.postValue(ImageItemMapper.mapListEntitiesToUiItems(list))
        }
    }
}