package com.example.trainingproject.service

import android.graphics.Color
import android.widget.Button
import kotlin.random.Random

object RandomColor {

    fun setButtonBackground(button: Button) {
        val randomValues = List(3) { Random.nextInt(0, 256) }
        val randomColor: Int = Color.argb(255, randomValues[0], randomValues[1], randomValues[2])
        button.setBackgroundColor(randomColor)
    }

}