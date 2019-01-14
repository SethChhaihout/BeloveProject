package com.planbcambodia.beloveproject.activity

import android.os.Bundle
import android.os.Handler
import android.support.design.internal.NavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.widget.DividerItemDecoration
import android.view.Gravity
import android.view.View
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Circle
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.fragment.HomeFragment
import com.planbcambodia.beloveproject.fragment.MatchingFragment
import com.planbcambodia.beloveproject.fragment.NoConnectionFragment
import com.planbcambodia.beloveproject.helper.BottomNavigationViewHelper
import com.planbcambodia.beloveproject.intf.OnNaviButtonClick
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_toolbar.*

class MainActivity : BaseActivity(),OnNaviButtonClick {
    override fun OnNaviButtonClicked() {
        openNavigationDrawer()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.tabHome -> {
                val homeFragment = HomeFragment()
                homeFragment.onNaviButtonClick = this
                replaceFragment(homeFragment)
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
        //set ProgressBar
        setUpProgressBar()
        // bottom navigation
        bottomNavigation()
        // set divider navigation drawer
        dividerNavigationDrawer()
        nav_view.setNavigationItemSelectedListener { item ->
            var id = item.itemId
            when(id){
                R.id.navi_FAQ ->{
//                        Toast.makeText(this@MainActivity, "FAQ" , Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    private fun setUpProgressBar() {
        val circle : Sprite = Circle()
        spin_kit.setIndeterminateDrawable(circle)
        val handler = Handler()
        handler.postDelayed({
            spin_kit.visibility = View.GONE
            navigation.selectedItemId = R.id.tabHome
        }, 2000)
    }

    private fun openNavigationDrawer() {
            if (!drawer_layout.isDrawerOpen(GravityCompat.START)) drawer_layout.openDrawer(Gravity.START)
            else drawer_layout.closeDrawer(Gravity.END)
    }

    private fun bottomNavigation() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        BottomNavigationViewHelper.disableShiftMode(navigation)
    }

    private fun dividerNavigationDrawer() {
        val navigationMenuView : NavigationMenuView? = nav_view.getChildAt(0) as NavigationMenuView?
        navigationMenuView!!.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        nav_view.setNavigationItemSelectedListener { item ->
            item.isCheckable = true
            drawer_layout.closeDrawers()
            true
        }
    }

}
