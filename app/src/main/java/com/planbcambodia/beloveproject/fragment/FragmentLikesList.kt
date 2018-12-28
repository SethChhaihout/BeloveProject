package com.planbcambodia.beloveproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.LikeListAdapter
import com.planbcambodia.beloveproject.model.LikeList
import kotlinx.android.synthetic.main.fragment_likes_list.view.*

class FragmentLikesList : Fragment() {
    val likesList : ArrayList<LikeList> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view= inflater.inflate(
                R.layout.fragment_likes_list,
                container, false)

        setLikesList()
        var rv = view.rcl_likes_list
        rv.layoutManager = LinearLayoutManager(view.context)
        rv.adapter = LikeListAdapter(likesList, view.context,object :LikeListAdapter.OnLikeClickListener{
            override fun OnLikeListClick(item: LikeList) {

            }

        })

        rv?.adapter?.notifyDataSetChanged()

        return view
    }

    private fun setLikesList(){
        likesList.clear()
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
        likesList.add(LikeList("Abc", "18","Phnom Penh",""))
    }
}