package com.marina.dogquiz.guess_breed.data.mapper

import com.marina.dogquiz.guess_breed.domain.entity.Answer

object GuessDogGameDataMapper {

    fun mapStringToAnswer(str: String): Answer {
        return Answer(str)
    }

    fun mapStringsToAnswers(set: Set<String>): Set<Answer> {
        return set.map {
            mapStringToAnswer(it)
        }.toSet()
    }
}