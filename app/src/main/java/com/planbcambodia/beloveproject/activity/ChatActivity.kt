package com.planbcambodia.beloveproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.ChatAdapter
import com.planbcambodia.beloveproject.model.Chat
import com.planbcambodia.beloveproject.model.ChatType
import com.planbcambodia.beloveproject.model.Partner
import com.planbcambodia.beloveproject.model.User
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    val chats: ArrayList<Chat> = ArrayList()
    val user_id: Int=0
    val partner_id : Int=0
    var key : String=""
    var chatType : ChatType= ChatType(0,"")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        imv_back.setOnClickListener { finish() }

        rclChat.layoutManager = LinearLayoutManager(applicationContext)
        key=("12")
        getChatHistory()

        rclChat.adapter = ChatAdapter(chats,applicationContext);
        rclChat?.adapter?.notifyDataSetChanged()

    }
    fun getChatHistory() {
        chats.clear()
        chats.add(Chat(false, "2018-12-01 4:08:34", "2","1", ChatType(1,"Hello")))
        chats.add(Chat(true, "2018-12-03 5:08:34", "1","1", ChatType(2,"Doing now?")))
        chats.add(Chat(true, "2018-12-04 6:08:34", "1","1", ChatType(1,"Eat rice yet?")))
        chats.add(Chat(false, "2018-12-02 3:08:34", "2","1", ChatType(2,"I love you!")))
    }
}
