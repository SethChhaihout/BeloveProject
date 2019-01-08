package com.planbcambodia.beloveproject

import android.os.Bundle
import android.support.design.internal.NavigationMenu
import android.support.design.internal.NavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.view.View
import com.planbcambodia.beloveproject.fragment.HomeFragment
import com.planbcambodia.beloveproject.fragment.MatchingFragment
import com.planbcambodia.beloveproject.fragment.NoConnectionFragment
import com.planbcambodia.beloveproject.helper.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.tabHome -> {
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.tabMatching -> {
                replaceFragment(MatchingFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.tabChat -> {
                replaceFragment(NoConnectionFragment())
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

//        val naviationMenuView : NavigationMenuView? = nav_view.getChildAt(0) as NavigationMenuView?
//        navigationMenuView.addItemDecoration(Devide)
    }
}
