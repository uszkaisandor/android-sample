package com.example.trainingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.trainingproject.service.RandomColor
import kotlinx.android.synthetic.main.activity_main.*

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

        btnTabFirst.setOnClickListener{
        }

        btnTabSecond.setOnClickListener{
        }

        btnTabThird.setOnClickListener{
        }

        iconButtonLeft.setOnClickListener{

        }

        iconButtonCenter.setOnClickListener{

        }

        iconButtonRight.setOnClickListener{

        }

    }
}
