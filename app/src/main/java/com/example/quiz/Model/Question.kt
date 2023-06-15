package com.example.quiz.Model

data class Question(
    val id: Int,
    val name: String,
    val imageId: Int,
    val answers: List<String>
)