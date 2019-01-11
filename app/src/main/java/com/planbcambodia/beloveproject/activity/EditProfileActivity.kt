package com.planbcambodia.beloveproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.planbcambodia.beloveproject.adapter.ProfileItemAdapter
import com.planbcambodia.beloveproject.adapter.ProfilePhotoAdapter
import com.planbcambodia.beloveproject.constant.Constant
import com.planbcambodia.beloveproject.model.ProfilePhoto
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : NetworkActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        setBackable(true)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val profilePhotos = Constant.testProfilePhoto
        profilePhotos.add(0, ProfilePhoto(""))
        val photoAdapter = ProfilePhotoAdapter(profilePhotos)
        recyclerView.adapter = photoAdapter

        recyclerViewProfileItem.layoutManager = LinearLayoutManager(this)
        val adapter = ProfileItemAdapter(Constant.testProfileItem)
        recyclerViewProfileItem.adapter = adapter
    }
}
