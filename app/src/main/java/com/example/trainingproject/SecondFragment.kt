package com.example.trainingproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : BaseFragment() {
    override fun getTitle(): Int {
        return R.string.grid
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.second_fragment, container, false)
        val textView = view.findViewById<TextView>(R.id.tv_fragment_2)
        textView.setText(R.string.fragment_2)

        return view
    }
}
