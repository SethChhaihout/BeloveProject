package com.planbcambodia.beloveproject.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.helper.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.tabHome -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.tabMatching -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.tabChat -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.tabMyPage -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        BottomNavigationViewHelper.disableShiftMode(navigation)
    }
}
