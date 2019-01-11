package com.planbcambodia.beloveproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.model.ProfileItem
import kotlinx.android.synthetic.main.viewholder_item_value.view.*

/**
 * Created by Panha Sakvisa on 1/9/2019.
 */
class ProfileItemAdapter(val profileItems:List<ProfileItem>) : RecyclerView.Adapter<ProfileItemAdapter.ProfileItemViewHoder>(){
    override fun onBindViewHolder(holder: ProfileItemViewHoder, position: Int) {
        holder.bindView(profileItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileItemViewHoder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_item_value,parent,false)
        return ProfileItemViewHoder(view)
    }

    override fun getItemCount(): Int {
        return profileItems.size
    }

    class ProfileItemViewHoder(view:View) : RecyclerView.ViewHolder(view){
        fun bindView(profileItem: ProfileItem){
            itemView.itemName.text = profileItem.name
            itemView.itemValue.text = profileItem.value
        }
    }
}