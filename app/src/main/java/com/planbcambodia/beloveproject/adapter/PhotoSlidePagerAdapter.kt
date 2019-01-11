package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.model.ProfilePhoto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_image_slide.view.*

/**
 * Created by Panha Sakvisa on 1/10/2019.
 */
class PhotoSlidePagerAdapter(val context: Context,val profilePhotos:List<ProfilePhoto>) : PagerAdapter(){
    override fun isViewFromObject(view: View, `object`: Any): Boolean = view.equals(`object`)

    override fun getCount(): Int = profilePhotos.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_image_slide,container,false)
        Glide.with(context)
                .load(R.drawable.dummy_photo)
                .into(view.photo)

        container.addView(view)
        return view
    }
}