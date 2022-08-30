package com.marina.dogquiz.guide.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marina.dogquiz.guide.domain.use_case.GetBreedsUseCase
import com.marina.dogquiz.guide.presentation.entity.BreedItem
import com.marina.dogquiz.guide.presentation.mapper.BreedItemMapper
import kotlinx.coroutines.launch

class BreedViewModel(
    private val getBreedsUseCase: GetBreedsUseCase
) : ViewModel() {

    private var _breeds = MutableLiveData<List<BreedItem>>()
    val breeds: LiveData<List<BreedItem>> get() = _breeds

    init {
        getBreedList()
    }

    fun getBreedList(query: String = "") {
        viewModelScope.launch {
            val list = getBreedsUseCase(query)
            _breeds.postValue(BreedItemMapper.mapListEntitiesToUiItems(list))
        }
    }
}