package com.example.trainingproject.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.trainingproject.BaseFragment
import com.example.trainingproject.grid.SecondFragment
import com.example.trainingproject.maps.ThirdFragment
import com.example.trainingproject.user.FirstFragment


class ViewPagerAdapter internal constructor(fm: FragmentManager, private val context: Context) :
    FragmentPagerAdapter(fm) {

    private val COUNT = 3

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
            2 -> fragment = ThirdFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString((getItem(position) as BaseFragment).getTitle())
    }
}
