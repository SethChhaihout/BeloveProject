package com.planbcambodia.beloveproject.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView

import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.activity.MatchingDetailActivity
import com.planbcambodia.beloveproject.adapter.MyRecyclerAdapter
import com.planbcambodia.beloveproject.adapter.OnImageClickListener
import com.planbcambodia.beloveproject.intf.OnNaviButtonClick
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    var photoes = ArrayList<Int>()
    var onNaviButtonClick : OnNaviButtonClick? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_home, container, false)
        //Recycler view Animation
        val sliderImages : HashMap<String, Int> = HashMap()
        sliderImages.put("image1", R.drawable.image_banner1)
        sliderImages.put("image2", R.drawable.image_banner2)
        sliderImages.put("image3", R.drawable.image_banner3)
        for ( name : String in sliderImages.keys){
            val textSliderView = TextSliderView(context)
            textSliderView
                    .description(name)
                    .image(sliderImages[name]!!)
                    .scaleType = BaseSliderView.ScaleType.Fit
            textSliderView.bundle(Bundle())
            textSliderView.bundle.putString("extra", name)
            view.slider.addSlider(textSliderView)
        }

        view.slider.setPresetTransformer(SliderLayout.Transformer.Default)
        view.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        view.slider.setCustomAnimation(DescriptionAnimation())
        view.slider.setDuration(9000)

        //Load images to arraylist
        addPhotoes()

        val adapter = MyRecyclerAdapter(photoes, view.context, object : OnImageClickListener{
            override fun onImageClick(item: Int) {
                val intent = Intent(context, MatchingDetailActivity::class.java)
                startActivity(intent)
            }
        })
        view.rvUsers.adapter = adapter
        adapter.notifyDataSetChanged()
        view.rvUsers.scheduleLayoutAnimation()

        view.findViewById<View>(R.id.btn_navi_icon).setOnClickListener { v->
            if(onNaviButtonClick != null){
                onNaviButtonClick!!.OnNaviButtonClicked()
            }
        }
        return view
    }

    private fun addPhotoes() {
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
        photoes.add(R.drawable.image1)
        photoes.add(R.drawable.images2)
    }

}
