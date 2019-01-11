package com.planbcambodia.beloveproject

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.widget.Toast
import com.planbcambodia.beloveproject.fragment.FragmentChatList
import com.planbcambodia.beloveproject.fragment.FragmentChatListContainer
import com.planbcambodia.beloveproject.fragment.FragmentLikesList
import com.planbcambodia.beloveproject.fragment.HomeFragment
import com.planbcambodia.beloveproject.fragment.MatchingFragment
import com.planbcambodia.beloveproject.fragment.NoConnectionFragment
import com.planbcambodia.beloveproject.helper.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : NetworkActivity() {

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
                Toast.makeText(baseContext,"Chat",Toast.LENGTH_SHORT).show()
                replaceFragment(FragmentChatListContainer())
                return@OnNavigationItemSelectedListener true
            }
            R.id.tabMyPage -> {
                replaceFragment(FragmentLikesList())
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
