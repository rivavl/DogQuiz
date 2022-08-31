package com.marina.dogquiz.guess_breed.domain.entity

data class GuessDogGame(
    val imageUrl: String,
    val answers: List<Answer>,
    val correctAnswer: Answer
)