package com.planbcambodia.beloveproject.activity

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.PhotoSlidePagerAdapter
import com.planbcambodia.beloveproject.constant.Constant
import com.planbcambodia.beloveproject.model.ProfilePhoto
import kotlinx.android.synthetic.main.activity_photo_slide.*

class PhotoSlideActivity : PhotoActivity() {
    var profilePhotos:ArrayList<ProfilePhoto>? = null
    lateinit var photoSlideAdapter:PhotoSlidePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_slide)
        profilePhotos = Constant.testProfilePhoto

        setBackable(true)

        photoSlideAdapter = PhotoSlidePagerAdapter(this, profilePhotos!!)
        viewPager.adapter = photoSlideAdapter
        toolbarTitle.text = "${viewPager.currentItem+1} of ${profilePhotos!!.size}"
        viewPager.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                toolbarTitle.text = "${position+1} of ${profilePhotos!!.size}"
            }
        })

        delete.setOnClickListener { v->
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.remove))
            builder.setMessage(getString(R.string.want_to_remove))
            builder.setNegativeButton(getString(R.string.no),object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
            builder.setPositiveButton(getString(R.string.yes),object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    profilePhotos!!.removeAt(viewPager.currentItem)
                    photoSlideAdapter.notifyDataSetChanged()
                    toolbarTitle.text = "${viewPager.currentItem+1} of ${profilePhotos!!.size}"
                }
            })
            alertDialog = builder.create()

            alertDialog?.setOnShowListener { it->
                alertDialog?.getButton(AlertDialog.BUTTON_NEGATIVE)?.setTextColor(ContextCompat.getColor(this,android.R.color.black))
                alertDialog?.getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(ContextCompat.getColor(this,android.R.color.black))
            }

            alertDialog?.show()
        }

        lytBtnAdd.setOnClickListener { v->
            selectImage()
        }
    }
}
