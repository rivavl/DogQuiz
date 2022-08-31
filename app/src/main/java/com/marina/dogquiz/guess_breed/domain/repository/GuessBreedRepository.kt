package com.marina.dogquiz.guess_breed.domain.repository

import com.marina.dogquiz.guess_breed.domain.entity.GameSettings
import com.marina.dogquiz.guess_breed.domain.entity.GuessDogGameQuestion
import com.marina.dogquiz.guess_breed.domain.entity.Level

interface GuessBreedRepository {

    suspend fun getGuessBreedQuestion(): GuessDogGameQuestion

    suspend fun getGameSettings(level: Level): GameSettings
}