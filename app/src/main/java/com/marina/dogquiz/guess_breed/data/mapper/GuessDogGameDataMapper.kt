package com.marina.dogquiz.guess_breed.data.mapper

import com.marina.dogquiz.guess_breed.domain.entity.Answer

object GuessDogGameDataMapper {

    fun mapStringToAnswer(str: String): Answer {
        return Answer(str)
    }

    fun mapStringsToAnswers(list: List<String>): List<Answer> {
        return list.map {
            mapStringToAnswer(it)
        }
    }
}