package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import kotlinx.android.synthetic.main.users_item_layout.view.*

/**
 * Created by Dell on 1/5/2019.
 */
class MyRecyclerAdapter(val items : ArrayList<Int>, val context : Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageResource(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.users_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val img = view.imgCustom
}