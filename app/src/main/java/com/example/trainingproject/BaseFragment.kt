package com.example.trainingproject

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract fun getTitle(): String
}
