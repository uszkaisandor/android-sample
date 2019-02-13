package com.example.trainingproject.service

import android.view.View

object ViewBackgroundChanger {
    fun setViewBackground(view: View) {
        val randomColor = RandomColor.generateColor()
        view.setBackgroundColor(randomColor)
    }
}