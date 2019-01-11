package com.planbcambodia.beloveproject.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.planbcambodia.belovecambodia.adapters.ChatListAdapter
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.activity.ChatActivity
import com.planbcambodia.beloveproject.model.ChatList
import kotlinx.android.synthetic.main.fragment_chat_list.view.*

/**
 * Created by HOM Srieng 12/28/2018
 */
class FragmentChatList : Fragment() {
    val chatLists: ArrayList<ChatList> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(
                R.layout.fragment_chat_list,
                container, false
        )

        setChatList()

        var rv = view.rcl_chat_list
        var imv_setting = view.lyt_show
        var imv_close   = view.lyt_close
        var layoutHide  = view.layout_setting_hide
        var layoutShow  = view.layout_setting_show
        var tv_done     = view.tv_done

        rv.layoutManager = LinearLayoutManager(view.context)
        rv.adapter = ChatListAdapter(chatLists, view.context, object : ChatListAdapter.OnChatClickListener {
            override fun OnChatListClick(item: ChatList) {
                Toast.makeText(view.context, "Clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(view.context,ChatActivity :: class.java)
                startActivity(intent)
            }
        })

        rv?.adapter?.notifyDataSetChanged()

        imv_setting.setOnClickListener {
            layoutHide.visibility = View.VISIBLE
            layoutShow.visibility = View.GONE
        }
        imv_close.setOnClickListener() {
            layoutHide.visibility = View.GONE
            layoutShow.visibility = View.VISIBLE
        }
        tv_done.setOnClickListener {
            layoutHide.visibility = View.GONE
            layoutShow.visibility = View.VISIBLE
        }
        return view
    }
    private fun setChatList() {
        chatLists.clear()
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))
        chatLists.add(ChatList("Viroth,32", R.mipmap.ic_user, "test send message",false,true))
        chatLists.add(ChatList("Abc,12", R.mipmap.ic_user, "test send message", true,false))

    }
}