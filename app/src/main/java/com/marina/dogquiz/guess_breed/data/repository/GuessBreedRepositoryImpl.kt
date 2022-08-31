package com.marina.dogquiz.guess_breed.data.repository

import com.marina.dogquiz.app.RetrofitInstance
import com.marina.dogquiz.guess_breed.data.mapper.GuessDogGameDataMapper
import com.marina.dogquiz.guess_breed.domain.entity.GameSettings
import com.marina.dogquiz.guess_breed.domain.entity.GuessDogGameQuestion
import com.marina.dogquiz.guess_breed.domain.entity.Level
import com.marina.dogquiz.guess_breed.domain.repository.GuessBreedRepository
import kotlin.random.Random

class GuessBreedRepositoryImpl : GuessBreedRepository {

    override suspend fun getGuessBreedQuestion(): GuessDogGameQuestion {
        val randomImage = RetrofitInstance.gameService.getRandomImage()
        val breeds = RetrofitInstance.gameService.getAllBreeds()
        val correctAnswer = extractBreedFromUrl(randomImage.message)
        val allAnswers = generateAnswers(correctAnswer, breeds.message)
        val allAnswersList = GuessDogGameDataMapper.mapStringsToAnswers(allAnswers)

        return GuessDogGameQuestion(
            randomImage.message,
            allAnswersList,
            GuessDogGameDataMapper.mapStringToAnswer(correctAnswer)
        )
    }

    private fun extractBreedFromUrl(url: String): String {
        val list = url.split("/")
        val breed = list[list.size - 2].split("-")[0]
        return breed
    }

    private fun generateAnswers(correct: String, breeds: List<String>): List<String> {
        val answers = mutableListOf(correct)
        while (answers.size < ANSWERS_COUNT) {
            val ans = breeds[Random.nextInt(0, breeds.size - 1)]
            if (ans !in answers) {
                answers.add(ans)
            }
        }
        return answers
    }

    override suspend fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> {
                GameSettings(
                    3,
                    50,
                    8
                )
            }
            Level.EASY -> {
                GameSettings(
                    10,
                    70,
                    60
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    20,
                    80,
                    40
                )
            }
            Level.HARD -> {
                GameSettings(
                    30,
                    90,
                    40
                )
            }
        }
    }

    companion object {
        private const val ANSWERS_COUNT = 4
    }
}