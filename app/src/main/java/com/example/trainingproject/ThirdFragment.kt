package com.example.trainingproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

class ThirdFragment : BaseFragment(), OnMapReadyCallback {
    override fun onMapReady(googleMap: GoogleMap?) {

    }

    override fun getTitle(): String {
        return getString(R.string.google_maps)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.third_fragment, container, false)
        return view
    }
}
