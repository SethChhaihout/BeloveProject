package com.planbcambodia.belovecambodia.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.model.ChatList
import kotlinx.android.synthetic.main.viewholder_chat_list.view.*

/**
 * Created by Srieng 21/12/2018
 */

class ChatListAdapter(
    val chatList: ArrayList<ChatList>,
    val context: Context,
    private var listener: OnChatClickListener
) : RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {


    open interface OnChatClickListener {
        fun OnChatListClick(item: ChatList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_chat_list, parent, false))
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList.get(position)
        Log.d("getName", "" + chat.getUserName())
        holder.tvName.setText(chat.getUserName())
        holder.tvLastMsg.setText(chat.getLastMessage())
        holder.tvTime.setText(chat.getUserTime())

        holder.Bind(chatList.get(position), this.listener!!)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Holds the TextView that will add each animal to
        val tvName = itemView.tvName
        val tvLastMsg = itemView.tvLastMessage
        val tvTime = itemView.tvTime

        fun Bind(chat: ChatList, listener: ChatListAdapter.OnChatClickListener) {

            tvName.text = chat.getUserName()
            tvLastMsg.text = chat.getLastMessage()
            tvTime.text = chat.getUserTime()
            itemView.setOnClickListener({
                listener.OnChatListClick(chat)
            })
        }
    }
}