package com.planbcambodia.beloveproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.planbcambodia.belovecambodia.adapters.ChatListAdapter
import com.planbcambodia.beloveproject.R
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
        var imv_setting = view.imv_setting_show
        var imv_close   = view.imv_close
        var layoutHide  = view.layout_setting_hide
        var layoutShow  = view.layout_setting_show

        rv.layoutManager = LinearLayoutManager(view.context)
        rv.adapter = ChatListAdapter(chatLists, view.context, object : ChatListAdapter.OnChatClickListener {
            override fun OnChatListClick(item: ChatList) {
                Toast.makeText(view.context, "${item.getUserName()}", Toast.LENGTH_SHORT).show()
                //val intent = Intent(view.context,ChatActivity :: class.java)
                //startActivity(intent)
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
        return view
    }
    private fun setChatList() {
        chatLists.clear()
        chatLists.add(ChatList("ddd", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))
        chatLists.add(ChatList("Abc", "1", "test send message", "2.00"))

    }
}