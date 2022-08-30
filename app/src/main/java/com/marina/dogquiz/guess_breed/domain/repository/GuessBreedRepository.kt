package com.marina.dogquiz.guess_breed.domain.repository

import com.marina.dogquiz.guess_breed.domain.entity.GuessDogGame

interface GuessBreedRepository {
    suspend fun getGuessBreedQuestion(): GuessDogGame
}