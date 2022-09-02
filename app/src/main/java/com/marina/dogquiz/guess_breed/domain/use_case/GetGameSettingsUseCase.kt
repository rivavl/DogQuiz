package com.marina.dogquiz.guess_breed.domain.use_case

import com.marina.dogquiz.guess_breed.domain.entity.GameSettings
import com.marina.dogquiz.guess_breed.domain.entity.Level
import com.marina.dogquiz.guess_breed.domain.repository.GuessBreedRepository

class GetGameSettingsUseCase(
    private val repository: GuessBreedRepository
) {

    suspend operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}