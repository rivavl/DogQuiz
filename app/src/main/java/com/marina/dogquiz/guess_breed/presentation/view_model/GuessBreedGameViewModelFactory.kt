package com.marina.dogquiz.guess_breed.presentation.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marina.dogquiz.guess_breed.domain.entity.Level
import com.marina.dogquiz.guess_breed.domain.use_case.GetGameSettingsUseCase
import com.marina.dogquiz.guess_breed.domain.use_case.GetGuessBreedQuestionUseCase

class GuessBreedGameViewModelFactory(
    private val getGameSettingsUseCase: GetGameSettingsUseCase,
    private val getGuessBreedQuestionUseCase: GetGuessBreedQuestionUseCase,
    private val level: Level,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GuessBreedGameViewModel(
            getGameSettingsUseCase,
            getGuessBreedQuestionUseCase,
            level,
            application
        ) as T
    }
}