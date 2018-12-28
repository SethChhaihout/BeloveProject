package com.planbcambodia.beloveproject.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.ChatListPaperAdapter
import kotlinx.android.synthetic.main.fragment_chatlist_container.*

class FragmentChatListContainer : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(
                R.layout.fragment_chatlist_container,
                container, false
        )

        val viewPager = view.findViewById<ViewPager>(R.id.viewpager_main)
        val tabs_main = view.findViewById<TabLayout>(R.id.tabs_main)

        if (viewPager != null) {
            val adapter = ChatListPaperAdapter(childFragmentManager)
            viewPager.adapter = adapter
            tabs_main.setupWithViewPager(viewPager)
        }
        tabs_main.getTabAt(0)?.setIcon(R.drawable.img_chat)
        tabs_main.getTabAt(1)?.setIcon(R.drawable.img_likes)
        tabs_main.getTabAt(2)?.setIcon(R.drawable.img_liked)
        return view
    }
}