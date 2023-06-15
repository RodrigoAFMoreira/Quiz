package com.example.quiz.Model

import com.example.quiz.R

object QuestionList {
    val questions = listOf(
        Question(
            id = 1,
            name = "Ruy Barbosa",
            imageId = R.drawable.ruy_barbosa,
            answers = listOf("Carlos Drummond", "Ruy Barbosa", "Getúlio Vargas", "Juscelino Kubitschek")
        ),
        Question(
            id = 2,
            name = "Carlos Drummond",
            imageId = R.drawable.carlos_drummond,
            answers = listOf("Paulo Coelho", "Ruy Barbosa", "Carlos Drummond", "Tom Jobin")
        ),
        Question(
            id = 3,
            name = "Getúlio Vargas",
            imageId = R.drawable.getulio_vargas,
            answers = listOf("Getúlio Vargas", "Tom Jobim", "Rui Barbosa", "Paulo Coelho")
        ),
        Question(
            id = 4,
            name = "Tom Jobim",
            imageId = R.drawable.tom_jobim,
            answers = listOf("Carlos Drummond", "Silvio Santos", "Tom Jobin", "Getúlio Vargas")
        ),
        Question(
            id = 5,
            name = "Carmen Miranda",
            imageId = R.drawable.carmen_miranda,
            answers = listOf("Zilda Arms", "Clarice Lispector", "Carmen Miranda", "Sonia Braga")
        ),
        Question(
            id = 6,
            name = "Zilda Arns",
            imageId = R.drawable.zilda_arns,
            answers = listOf("Zilda Arns", "Clarice Lispector","Carmen Miranda", "Sonia Braga")
        ),
        Question(
            id = 7,
            name = "Clarice Lispector",
            imageId = R.drawable.clarice_lispector,
            answers = listOf("Carmen Miranda", "Hortência", "Clarice Lispector", "Zilda Arns")
        ),
        Question(
            id = 8,
            name = "Juscelino Kubitschek",
            imageId = R.drawable.juscelino_kubitschek,
            answers = listOf("Carlos Drummond", "Getúlio Vargas", "Juscelino Kubitschek", "Ruy Barbosa")
        ),
        Question(
            id = 9,
            name = "Sonia Braga",
            imageId = R.drawable.sonia_braga,
            answers = listOf("Zilda Arns", "Sonia Braga", "Hortência", "Carmen Miranda")
        ),
        Question(
            id = 10,
            name = "Hortência",
            imageId = R.drawable.hortencia,
            answers = listOf("Carmen Miranda", "Zilda Arns", "Sonia Braga", "Hortência")
        )
    ).map { question ->
        question.copy(answers = question.answers.shuffled())
    }
}