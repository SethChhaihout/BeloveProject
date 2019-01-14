package com.planbcambodia.beloveproject.fragment


import android.content.Intent
import android.os.Bundle
import android.support.transition.TransitionInflater
import android.support.v4.app.Fragment
import android.transition.Slide
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast

import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.activity.MatchingDetailActivity
import com.planbcambodia.beloveproject.intf.CardClickListener
import kotlinx.android.synthetic.main.card.*
import kotlinx.android.synthetic.main.card.view.*
import kotlinx.android.synthetic.main.fragment_matching.view.*
import kotlinx.android.synthetic.main.main_toolbar.*
import kotlinx.android.synthetic.main.main_toolbar.view.*
import link.fls.swipestack.SwipeStack
import kotlin.collections.ArrayList

class MatchingFragment : Fragment(),SwipeStack.SwipeStackListener,SwipeStack.OnSwipeProgress,CardClickListener{

    override fun onCardClick(id: Int) {
        val intent = Intent(context, MatchingDetailActivity::class.java )
        startActivity(intent)
    }

    override fun onSwipe(swipeProgress: Float) {
        when {
            swipeProgress < 0 -> view!!.ic_sorry.alpha=-swipeProgress*4
            swipeProgress > 0 -> view!!.ic_love.alpha=swipeProgress*4
            swipeProgress == 0f -> {
                view!!.ic_love.animate().alpha(0f)
                view!!.ic_sorry.animate().alpha(0f)
            }
        }
    }

    var mData = ArrayList<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_matching, container, false)
        view.ic_love.alpha = 0f
        view.ic_sorry.alpha = 0f
        fillWithTestData()
        val mAdapter = SwipeStackAdapter(this,mData)
        view.swipeStack.adapter = mAdapter
        view.swipeStack.setListener(this)
        view.swipeStack.setOnSwipeProgressListener(this)
        return view
    }
    private fun fillWithTestData() {
        for (x in 0..100) {
            mData.add( "Test" + " " + (x + 1))
        }
    }

    override fun onViewSwipedToLeft(position: Int) {
        view!!.btn_navi_icon.visibility = View.GONE
        view!!.btn_return_icon.visibility = View.VISIBLE
    }

    override fun onViewSwipedToRight(position: Int) {
        view!!.btn_navi_icon.visibility = View.VISIBLE
        view!!.btn_return_icon.visibility = View.GONE
    }

    override fun onStackEmpty() {}

    class SwipeStackAdapter(private val cardClickListener: CardClickListener,private val mData : List<String>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            if (convertView == null){
                val view = LayoutInflater.from(parent!!.context).inflate(R.layout.card,parent,false)
                view.card_detail.setOnTouchListener { v, event ->
                    view.card_detail.parent.requestDisallowInterceptTouchEvent(true)
                    cardClickListener.onCardClick(position)
                    return@setOnTouchListener false
                }
                return view
            }
            return convertView
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