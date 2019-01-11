package com.planbcambodia.beloveproject.adapter

import android.support.v7.widget.AppCompatCheckBox
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.model.Hobbie
import com.planbcambodia.beloveproject.model.ProfileItem
import kotlinx.android.synthetic.main.viewholder_hobbie_item.view.*

/**
 * Created by Panha Sakvisa on 1/9/2019.
 */
class HobbieAdapter(val hobbies: List<Hobbie>) : RecyclerView.Adapter<HobbieAdapter.HobbieViewHoder>() {
    var selectedPostion: Int = 0

    override fun onBindViewHolder(holder: HobbieViewHoder, position: Int) {
        holder.itemView.itemName.text = hobbies[position].name
        holder.itemView.checkbox.isChecked = position == selectedPostion
        holder.bindAdapter(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbieViewHoder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_hobbie_item, parent, false)
        return HobbieViewHoder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    class HobbieViewHoder(view: View) : RecyclerView.ViewHolder(view){
        fun bindAdapter(adapter: HobbieAdapter){
            itemView.checkbox.setOnClickListener { v ->
                if(itemView.checkbox.isChecked){
                    val oldPosition = adapter.selectedPostion
                    adapter.selectedPostion = adapterPosition
                    adapter.notifyItemChanged(oldPosition)
                    adapter.notifyItemChanged(adapterPosition)
                }
            }
        }
    }
}