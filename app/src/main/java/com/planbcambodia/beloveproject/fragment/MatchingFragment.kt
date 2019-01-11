package com.planbcambodia.beloveproject.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import com.planbcambodia.beloveproject.R
import kotlinx.android.synthetic.main.fragment_matching.view.*
import link.fls.swipestack.SwipeStack
import kotlin.collections.ArrayList

class MatchingFragment : Fragment(),SwipeStack.SwipeStackListener{
    lateinit var mData : ArrayList<String>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_matching, container, false)
        mData = ArrayList()
        fillWithTestData()
        val mAdapter = SwipeStackAdapter(mData)
        view.swipeStack.adapter = mAdapter
        return view
    }

    private fun fillWithTestData() {
        for (x in 0..100) {
            mData.add( "Test" + " " + (x + 1))
        }
    }

    override fun onViewSwipedToLeft(position: Int) {

    }

    override fun onViewSwipedToRight(position: Int) {

    }

    override fun onStackEmpty() {

    }

    class SwipeStackAdapter(private val mData : List<String>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            if (convertView == null){
                return LayoutInflater.from(parent!!.context).inflate(R.layout.card,parent,false)
            }
            return convertView!!
        }

        override fun getItem(position: Int): Any {
            return mData[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return mData.size
        }
    }
}