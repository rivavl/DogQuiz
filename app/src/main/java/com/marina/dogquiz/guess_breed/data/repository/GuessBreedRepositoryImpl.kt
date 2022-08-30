package com.marina.dogquiz.guess_breed.data.repository

import com.marina.dogquiz.app.RetrofitInstance
import com.marina.dogquiz.guess_breed.data.mapper.GuessDogGameDataMapper
import com.marina.dogquiz.guess_breed.domain.entity.GuessDogGame
import com.marina.dogquiz.guess_breed.domain.repository.GuessBreedRepository
import kotlin.random.Random

class GuessBreedRepositoryImpl : GuessBreedRepository {

    override suspend fun getGuessBreedQuestion(): GuessDogGame {
        val randomImage = RetrofitInstance.gameService.getRandomImage()
        val breeds = RetrofitInstance.gameService.getAllBreeds()
        val correctAnswer = extractBreedFromUrl(randomImage.message)
        val allAnswers = generateAnswers(correctAnswer, breeds.message)
        val allAnswersSet = GuessDogGameDataMapper.mapStringsToAnswers(allAnswers)
        return GuessDogGame(
            randomImage.message,
            allAnswersSet,
            GuessDogGameDataMapper.mapStringToAnswer(correctAnswer)
        )
    }

    private fun extractBreedFromUrl(url: String): String {
        val list = url.split("/")
        val breed = list[list.size - 2].split("-")[0]
        return breed
    }

    private fun generateAnswers(correct: String, breeds: List<String>): Set<String> {
        val answers = mutableSetOf(correct)
        while (answers.size < ANSWERS_COUNT) {
            val ans = breeds[Random.nextInt(0, breeds.size - 1)]
            if (ans !in answers) {
                answers.add(ans)
            }
        }
        return answers
    }

    companion object {
        private const val ANSWERS_COUNT = 4
    }
}