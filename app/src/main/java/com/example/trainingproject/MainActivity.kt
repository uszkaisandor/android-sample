package com.example.trainingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.viewpagerindicator.TabPageIndicator
import com.viewpagerindicator.TitlePageIndicator



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<View>(R.id.view_pager) as ViewPager
        viewPager.adapter = CustomPagerAdapter(this)

        val titleIndicator = findViewById<TabPageIndicator>(R.id.view_pager_indicator)
        titleIndicator.setViewPager(viewPager)
    }
}
