package com.marina.dogquiz.guess_breed.domain.entity

data class GuessDogGame(
    val imageUrl: String,
    val answers: Set<Answer>,
    val correctAnswer: Answer
)