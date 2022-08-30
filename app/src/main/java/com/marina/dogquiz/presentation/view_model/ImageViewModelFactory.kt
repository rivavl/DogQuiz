package com.marina.dogquiz.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marina.dogquiz.domain.use_case.GetImagesUseCase

class ImageViewModelFactory(
    private val useCase: GetImagesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImagesViewModel(useCase) as T
    }
}