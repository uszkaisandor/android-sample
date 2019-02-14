package com.example.trainingproject

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    val animationTime = 500L
    abstract fun getTitle(): Int
}
