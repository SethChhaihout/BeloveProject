package com.planbcambodia.beloveproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.BlockedUsersListAdapter
import com.planbcambodia.beloveproject.adapter.LikeListAdapter
import com.planbcambodia.beloveproject.model.ChatList
import com.planbcambodia.beloveproject.model.LikeList
import com.planbcambodia.beloveproject.model.User
import kotlinx.android.synthetic.main.activity_blocked_users.*
import kotlinx.android.synthetic.main.fragment_blocked_users_list.view.*
import kotlinx.android.synthetic.main.fragment_likes_list.view.*


class FragmentBlockedUsersList : Fragment() {
    val blockList : ArrayList<User> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(
                R.layout.fragment_blocked_users_list,
                container, false
        )

        setLikesList()
        var rv = view.rcl_block_list
        rv.layoutManager = LinearLayoutManager(view.context)
        rv.adapter = BlockedUsersListAdapter(blockList, view.context,object: BlockedUsersListAdapter.OnBlockListClickListener{
            override fun OnBlockListClick(item: ChatList) {
                Toast.makeText(context,"Ok",Toast.LENGTH_SHORT).show()
            }
        })
        rv?.adapter?.notifyDataSetChanged()
        return view
    }
    private fun setLikesList(){
        blockList.clear()
        blockList.add(User("1","ABC",""))
        blockList.add(User("2","DD",""))
        blockList.add(User("3","CCCCC",""))
        blockList.add(User("4","ABAAAC",""))
        blockList.add(User("5","ABCCC",""))
        blockList.add(User("6","ABSSSSC",""))

    }
}