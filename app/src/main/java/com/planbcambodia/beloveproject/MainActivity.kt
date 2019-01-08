package com.planbcambodia.beloveproject

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.planbcambodia.beloveproject.fragment.HomeFragment
import com.planbcambodia.beloveproject.helper.BottomNavigationViewHelper
import com.planbcambodia.beloveproject.util.Dialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : NetworkActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.tabHome -> {
                replaceFragment(HomeFragment())
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
