package com.example.trainingproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trainingproject.service.RandomColor
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.drawable.ColorDrawable



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
            val toastMessage = "Left icon button pressed!"
            val textColor = Color.parseColor("#ffffff");
            val backgroundColor = (btnTabFirst.background as ColorDrawable).color
            DynamicToast.make(applicationContext, toastMessage, textColor , backgroundColor).show();
        }

        iconButtonCenter.setOnClickListener{

        }

        iconButtonRight.setOnClickListener{

        }

    }
}
