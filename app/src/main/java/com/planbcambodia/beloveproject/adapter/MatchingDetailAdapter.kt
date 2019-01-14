package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import kotlinx.android.synthetic.main.custom_item_matching_detail.view.*

/**
 * Created by chhaihout on 1/9/2019.
 */
class MatchingDetailAdapter(var title : ArrayList<String>,var description : ArrayList<String>,val context : Context) : RecyclerView.Adapter<MatchingDetailAdapter.MyViewHolder>(){
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle.text = title[position]
        holder.txtDes.text = description[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.custom_item_matching_detail, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size
    }


    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtTitle = view.txtTitle_in_matching_detail
        val txtDes = view.txtDes_in_matching_detail
    }
}
