package com.example.trainingproject

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    val ANIMATION_TIME = 500L
    abstract fun getTitle(): Int
}
