package com.marina.dogquiz.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marina.dogquiz.domain.use_case.GetBreedsUseCase

class BreedViewModelFactory(
    private val useCase: GetBreedsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BreedViewModel(useCase) as T
    }
}