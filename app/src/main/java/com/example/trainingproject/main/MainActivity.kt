package com.example.trainingproject.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.trainingproject.R
import com.example.trainingproject.service.ViewBackgroundChanger
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import de.mateware.snacky.Snacky
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.first_fragment.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewPager?.let {
            val adapter = ViewPagerAdapter(supportFragmentManager, this)
            viewPager.adapter = adapter
        }
        setButtonColors()
        setButtonListeners()
        setIconButtonListeners()
        setPagerIndicatorColor()
        setToolbarListeners()
    }

    private fun setPagerIndicatorColor() {
        pagerHeader.setTabIndicatorColorResource(R.color.colorIndicator)
        pagerHeader.setTextColor(ContextCompat.getColor(this, R.color.white))
    }


    private fun setButtonColors() {
        ViewBackgroundChanger.setViewBackground(btnTabFirst)
        ViewBackgroundChanger.setViewBackground(btnTabSecond)
        ViewBackgroundChanger.setViewBackground(btnTabThird)
    }


    private fun setButtonListeners() {
        btnTabFirst.setOnClickListener {
            viewPager.setCurrentItem(0, true)
        }

        btnTabSecond.setOnClickListener {
            viewPager.setCurrentItem(1, true)
        }

        btnTabThird.setOnClickListener {
            viewPager.setCurrentItem(2, true)
        }
    }

    private fun setIconButtonListeners() {
        iconButtonLeft.setOnClickListener {
            val toastMessage = getString(R.string.left_icon_button_pressed)
            val textColor = Color.parseColor("#ffffff")
            val backgroundColor = (btnTabFirst.background as ColorDrawable).color
            DynamicToast.make(applicationContext, toastMessage, textColor, backgroundColor).show()
        }

        iconButtonCenter.setOnClickListener {
            val textColor = Color.parseColor("#ffffff")
            val backgroundColor = (btnTabSecond.background as ColorDrawable).color
            Snacky.builder()
                .setActivity(this@MainActivity)
                .setText(R.string.center_icon_button_pressed)
                .setTextColor(textColor)
                .centerText()
                .setBackgroundColor(backgroundColor)
                .setDuration(Snacky.LENGTH_SHORT)
                .build()
                .show()
        }

        iconButtonRight.setOnClickListener {
            val alertDialog: AlertDialog? = this.let {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.apply {
                    setPositiveButton(
                        R.string.ok
                    ) { dialog, id ->
                        dialog.dismiss()
                    }
                    setTitle(R.string.alert_dialog_title)
                    setMessage(R.string.alert_dialog_message)
                }
                builder.create()
            }
            alertDialog?.show()
            val backgroundColor = (btnTabThird.background as ColorDrawable)
            alertDialog?.window?.setBackgroundDrawable(backgroundColor)
        }
    }

    private fun setToolbarListeners() {
        ivRefresh.setOnClickListener{
            setButtonColors()
        }
    }

}

