package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.model.LikeList
import kotlinx.android.synthetic.main.viewholder_chat_list.view.*

class LikeListAdapter (val chatList : ArrayList<LikeList>, val context: Context,private var listener: OnLikeClickListener) : RecyclerView.Adapter<LikeListAdapter.ViewHolder>(){

    open interface OnLikeClickListener {
        fun OnLikeListClick(item: LikeList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList.get(position)
        Log.d("getName", "" + chat.getUserName())
        holder.tvName.setText(chat.getUserName())
        if(chat.getIsActive()==true){
            holder.imvActive.visibility=View.VISIBLE
        }else{
            holder.imvActive.visibility=View.GONE
        }
        holder.imvStar.visibility=View.GONE

        holder.tvTime.setText(chat.getUserTime())
        holder.Bind(chatList.get(position), this.listener!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): LikeListAdapter.ViewHolder {
        return LikeListAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.viewholder_chat_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val tvName = view.tvName
        val imvProfile       =view.imgProfile
        val tvTime=view.tvLastMessage
        val imvActive=view.imv_chat_active
        val imvStar=view.imv_star

        fun Bind(chat: LikeList, listener: LikeListAdapter.OnLikeClickListener) {

            tvName.text     = chat.getUserName()
            tvTime.text = chat.getUserTime()
            imvProfile.setImageResource(chat.getUserPhoto())

            itemView.setOnClickListener({
                listener.OnLikeListClick(chat)
            })
        }
    }
}