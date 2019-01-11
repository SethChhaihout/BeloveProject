package com.planbcambodia.beloveproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.planbcambodia.beloveproject.R
import com.squareup.picasso.Picasso
import com.yanzhenjie.album.*
import com.yanzhenjie.album.api.widget.Widget
import java.util.ArrayList


open class PhotoActivity : NetworkActivity() {
    private var mAlbumFiles:ArrayList<AlbumFile> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        Album.initialize(AlbumConfig.newBuilder(this)
                .setAlbumLoader(MediaLoader())
                .build())
    }

    protected fun selectImage(){
        Album.image(this)
                .multipleChoice()
                .camera(true)
                .columnCount(3)
                .selectCount(6)
                .checkedList(mAlbumFiles)
                .onResult { result ->
                    mAlbumFiles = result
                    onReceiveImage(mAlbumFiles)
                }
                .start()
    }

    open fun onReceiveImage(files:ArrayList<AlbumFile>){

    }

    inner class MediaLoader : AlbumLoader {

        override fun load(imageView: ImageView, albumFile: AlbumFile) {
            load(imageView, albumFile.path)
        }

        override fun load(imageView: ImageView, url: String) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }
}
