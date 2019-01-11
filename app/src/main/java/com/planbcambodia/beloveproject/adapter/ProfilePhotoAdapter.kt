package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.model.ProfilePhoto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.viewholder_profile_photo.view.*

/**
 * Created by Panha Sakvisa on 1/9/2019.
 */
class ProfilePhotoAdapter(val profilePhotos:List<ProfilePhoto>,val onPhotoClickListener: OnPhotoClickListener) : RecyclerView.Adapter<ProfilePhotoAdapter.ProfilePhotoViewHoder>(){
    var context:Context? = null
    override fun onBindViewHolder(holder: ProfilePhotoViewHoder, position: Int) {
        holder.bindView(context!!,profilePhotos[position],onPhotoClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilePhotoViewHoder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_profile_photo,parent,false)
        context = parent.context
        return ProfilePhotoViewHoder(view)
    }

    override fun getItemCount(): Int {
        return profilePhotos.size
    }

    class ProfilePhotoViewHoder(view: View) : RecyclerView.ViewHolder(view){
        fun bindView(context:Context,profilePhoto: ProfilePhoto,onPhotoClickListener: OnPhotoClickListener){
            if(profilePhoto.url.isNotEmpty()){
                Picasso.with(context)
                        .load(R.drawable.dummy_photo)
                        .fit()
                        .centerCrop()
                        .into(itemView.photo)
            }else{
                itemView.photo.visibility = View.GONE
            }

            itemView.setOnClickListener { v->
                onPhotoClickListener.onPhotoClick(profilePhoto)
            }
        }
    }
}

interface OnPhotoClickListener{
    fun onPhotoClick(photo:ProfilePhoto);
}