package com.example.trainingproject.service

import android.graphics.Color
import android.view.View
import android.widget.Button
import kotlin.random.Random

object RandomColor {
    fun generateColor(): Int {
        val randomValues = List(3) { Random.nextInt(0, 256) }
        return  Color.argb(255, randomValues[0], randomValues[1], randomValues[2])
    }
}