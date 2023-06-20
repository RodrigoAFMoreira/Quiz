package com.example.quiz.Composable.Question

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageQuestion(imageResId: Int) {
    val imageBitmap = ImageBitmap.imageResource(imageResId)
    val painter: Painter = BitmapPainter(imageBitmap)
    Image(
        painter,
        contentDescription = null,
        modifier = Modifier
            .width(250.dp)
            .height(200.dp)
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )
}