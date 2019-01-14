package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.activity.MatchingDetailActivity
import kotlinx.android.synthetic.main.users_item_layout.view.*

/**
 * Created by Dell on 1/5/2019.
 */
class MyRecyclerAdapter(val items : ArrayList<Int>, val context : Context, val onImageClickListener: OnImageClickListener) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position],onImageClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.users_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
    var img:ImageView = view.imgCustom
    fun bindView(item:Int,onImageClickListener: OnImageClickListener){
        img.setImageResource(item)
        img.setOnClickListener {
            onImageClickListener.onImageClick(item)
        }
    }
}

interface OnImageClickListener{
    fun onImageClick(item:Int)
}