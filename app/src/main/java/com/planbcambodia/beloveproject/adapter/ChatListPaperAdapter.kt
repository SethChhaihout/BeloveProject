package com.planbcambodia.beloveproject.adapter
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.planbcambodia.beloveproject.fragment.FragmentChatList
import com.planbcambodia.beloveproject.fragment.FragmentLikedList
import com.planbcambodia.beloveproject.fragment.FragmentLikesList

/**
 * Created by HOM Srieng 12/28/2018
 */
class ChatListPaperAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 3;
    }
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {FragmentChatList()}
            1 -> {FragmentLikesList();}
            else -> {return FragmentLikedList()}
        }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Chat"
            1 -> "Likes"
            else -> { return "Liked"}
        }
    }
}