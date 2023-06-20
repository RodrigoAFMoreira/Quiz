package com.example.quiz.Model

import com.example.quiz.R

object QuestionList {
    val questions = listOf(
        Question(
            id = 1,
            name = "Ruy Barbosa",
            imageId = R.drawable.ruy_barbosa,
            answers = listOf("Ayrton Senna", "Ruy Barbosa", "Sergio Moro", "Gilberto Gil"),
            "Ruy Barbosa"
        ),
        Question(
            id = 2,
            name = "Carlos Drummond",
            imageId = R.drawable.carlos_drummond,
            answers = listOf("Faustão", "Rubem Braga", "Carlos Drummond", "Lampião"),
            "Carlos Drummond"
        ),
        Question(
            id = 3,
            name = "Getúlio Vargas",
            imageId = R.drawable.getulio_vargas,
            answers = listOf("Getúlio Vargas", "Ratinho", "Ernesto Geisel", "Jose Bonifacio"),
            "Getúlio Vargas"
        ),
        Question(
            id = 4,
            name = "Tom Jobim",
            imageId = R.drawable.tom_jobim,
            answers = listOf("Raul Seixas", "Sílvio Santos", "Tom Jobin", "Lobão"),
            "Tom Jobim"
        ),
        Question(
            id = 5,
            name = "Carmen Miranda",
            imageId = R.drawable.carmen_miranda,
            answers = listOf("Rita Lee", "Vera Fischer", "Carmen Miranda", "Gisele Bundchen"),
            "Carmen Miranda"
        ),
        Question(
            id = 6,
            name = "Zilda Arns",
            imageId = R.drawable.zilda_arns,
            answers = listOf("Zilda Arns", "Hebe Camargo","Helena Kolody", "Raquel de Queirós"),
            "Zilda Arns"
        ),
        Question(
            id = 7,
            name = "Clarice Lispector",
            imageId = R.drawable.clarice_lispector,
            answers = listOf("Maria Bonita", "Glenda Kozlowski", "Clarice Lispector", "Ana Maria Braga"),
            "Clarice Lispector"
        ),
        Question(
            id = 8,
            name = "Juscelino Kubitschek",
            imageId = R.drawable.juscelino_kubitschek,
            answers = listOf("Jânio Quadros", "Rafael Greca", "Juscelino Kubitschek", "William Bonner"),
            "Juscelino Kubitschek"
        ),
        Question(
            id = 9,
            name = "Sonia Braga",
            imageId = R.drawable.sonia_braga,
            answers = listOf("Michelle Bolsonaro", "Sonia Braga", "Maria da Penha", "Gleisi Hoffmann"),
            "Sonia Braga"
        ),
        Question(
            id = 10,
            name = "Hortência",
            imageId = R.drawable.hortencia,
            answers = listOf("Maria Quitéria", "Ana Terra", "Fazuele Peixoto", "Hortência"),
            "Hortência"
        )
    ).map { question ->
        question.copy(answers = question.answers.shuffled())
    }
}