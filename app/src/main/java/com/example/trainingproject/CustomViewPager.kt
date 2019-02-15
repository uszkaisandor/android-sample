package com.example.trainingproject

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.trainingproject.common.RxBus
import com.example.trainingproject.event.OnPageChangedEvent
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CustomViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return false
    }

    init {
        addOnPageChangeListener(object : SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                RxBus.publish(
                    OnPageChangedEvent(
                        adapter?.getPageTitle(position)?.toString() ?: context.getString(R.string.app_name)
                    )
                )
            }
        })
    }
}