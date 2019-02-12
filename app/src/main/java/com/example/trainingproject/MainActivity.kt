package com.example.trainingproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trainingproject.service.RandomColor
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager ?. let {
            val adapter = ViewPagerAdapter(supportFragmentManager)
            view_pager.adapter = adapter
        }

        RandomColor.setButtonBackground(btnTabFirst)
        RandomColor.setButtonBackground(btnTabSecond)
        RandomColor.setButtonBackground(btnTabThird)

        /*

        var randomValues = List(9) { Random.nextInt(0, 256) }

        val buttonTabFirstColor: Int =  Color.argb(255, randomValues[0], randomValues[1], randomValues[2])
        btnTabFirst.setBackgroundColor(buttonTabFirstColor)

        val buttonTabSecondColor: Int =  Color.argb(255, randomValues[3], randomValues[4], randomValues[5])
        btnTabSecond.setBackgroundColor(buttonTabSecondColor)

        val buttonTabThirdColor: Int =  Color.argb(255, randomValues[6], randomValues[7], randomValues[8])
        btnTabThird.setBackgroundColor(buttonTabThirdColor)*/


    }
}
