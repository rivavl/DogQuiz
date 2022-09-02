package com.marina.dogquiz.guess_breed.domain.entity

data class GuessDogGameQuestion(
    val imageUrl: String,
    val answers: List<Answer>,
    val correctAnswer: Answer
)