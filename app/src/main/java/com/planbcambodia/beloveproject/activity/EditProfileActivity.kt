package com.planbcambodia.beloveproject.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.OnPhotoClickListener
import com.planbcambodia.beloveproject.adapter.ProfileItemAdapter
import com.planbcambodia.beloveproject.adapter.ProfilePhotoAdapter
import com.planbcambodia.beloveproject.constant.Constant
import com.planbcambodia.beloveproject.model.ProfilePhoto
import com.yanzhenjie.album.AlbumFile
import kotlinx.android.synthetic.main.activity_edit_profile.*
import java.util.ArrayList

class EditProfileActivity : PhotoActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        setBackable(true)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val profilePhotos = Constant.testProfilePhoto
        profilePhotos.add(0, ProfilePhoto(""))
        val photoAdapter = ProfilePhotoAdapter(profilePhotos,object:OnPhotoClickListener{
            override fun onPhotoClick(photo: ProfilePhoto) {
                if(photo.url.isEmpty()){
                    selectImage()
                }else{
                    startActivity(Intent(this@EditProfileActivity,PhotoSlideActivity::class.java))
                }
            }
        })
        recyclerView.adapter = photoAdapter

        recyclerViewProfileItem.layoutManager = LinearLayoutManager(this)
        val adapter = ProfileItemAdapter(Constant.testProfileItem)
        recyclerViewProfileItem.adapter = adapter
    }

    override fun onReceiveImage(files: ArrayList<AlbumFile>) {
        super.onReceiveImage(files)

    }
}
