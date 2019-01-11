package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.model.ChatList
import com.planbcambodia.beloveproject.model.User
import kotlinx.android.synthetic.main.viewholder_blocked_users_list.view.*

class BlockedUsersListAdapter (
        val blockList: ArrayList<User>,
        val context: Context,
        private var listener: BlockedUsersListAdapter.OnBlockListClickListener
) : RecyclerView.Adapter<BlockedUsersListAdapter.ViewHolder>() {

    open interface OnBlockListClickListener {
        fun OnBlockListClick(item: ChatList)
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return BlockedUsersListAdapter.ViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.viewholder_blocked_users_list,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {
       return blockList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val block = blockList.get(position)
        holder.tvName.setText(block.getName())
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName               = itemView.tvName
        val imvProfile      = itemView.imgProfile

    }
}