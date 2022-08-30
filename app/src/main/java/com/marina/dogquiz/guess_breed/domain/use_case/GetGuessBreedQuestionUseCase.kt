package com.marina.dogquiz.guess_breed.domain.use_case

import com.marina.dogquiz.guess_breed.domain.entity.GuessDogGame
import com.marina.dogquiz.guess_breed.domain.repository.GuessBreedRepository

class GetGuessBreedQuestionUseCase(
    private val repository: GuessBreedRepository
) {
    suspend operator fun invoke(): GuessDogGame {
        return repository.getGuessBreedQuestion()
    }
}