package com.planbcambodia.beloveproject.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.ChatListPaperAdapter

class FragmentChatListContainer : Fragment() {

    var arrIconTabActive  = arrayListOf<Int>(R.drawable.img_chat,R.drawable.img_like_active,R.drawable.img_liked_active)
    var arrIconTabInActive= arrayListOf<Int>(R.drawable.img_chat_inactive,R.drawable.img_likes,R.drawable.img_liked)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(
                R.layout.fragment_chatlist_container,
                container, false
        )


        val viewPager = view.findViewById<ViewPager>(R.id.viewpager_main)
        val tabs_main = view.findViewById<TabLayout>(R.id.tabs_main)

        if (viewPager != null) {
            val adapter       = ChatListPaperAdapter(childFragmentManager)
            viewPager.adapter = adapter
            tabs_main.setupWithViewPager(viewPager)
        }

        loadDefaultTab(tabs_main)

        tabs_main.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                setTabCustom(tabs_main,R.color.colorPrimary,R.color.colorLightBlack,tab.position,arrIconTabInActive[tab.position])
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                setTabCustom(tabs_main,R.color.colorLightBlack,R.color.colorPrimary,tab.position,arrIconTabActive[tab.position])
            }
        })

        return view
    }

    //set custom tab with icon and text color
    private fun setTabCustom(tabs_main:TabLayout, color1 : Int, color2 : Int, position : Int, icon:Int){
        tabs_main.getTabAt(position)?.setIcon(icon)
        tabs_main.setTabTextColors(ContextCompat.getColor(requireContext(), color1),ContextCompat.getColor(requireContext(), color2));
    }

    private fun loadDefaultTab(tabs_main : TabLayout){
        setTabCustom(tabs_main,R.color.colorPrimary , R.color.colorLightBlack ,0 ,arrIconTabActive[0])
        setTabCustom(tabs_main,R.color.colorLightBlack , R.color.colorPrimary ,1 ,arrIconTabInActive[1])
        setTabCustom(tabs_main,R.color.colorLightBlack , R.color.colorPrimary ,2 ,arrIconTabInActive[2])
    }
}