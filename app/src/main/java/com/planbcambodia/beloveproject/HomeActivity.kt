package com.planbcambodia.beloveproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import kotlinx.android.synthetic.main.activity_home.*
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout




class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var sliderImages : HashMap<String, Int> = HashMap()
        sliderImages.put("image1", R.drawable.image_banner1)
        sliderImages.put("image2", R.drawable.image_banner2)
        sliderImages.put("image3", R.drawable.image_banner3)

        for (name : String in sliderImages.keys){
            val textSliderView : TextSliderView = TextSliderView(this)
            textSliderView
                    .description(name)
                    .image(sliderImages.get(name)!!).scaleType = BaseSliderView.ScaleType.Fit
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                    .putString("extra", name)
            sliderLayout.addSlider(textSliderView)
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default)
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        sliderLayout.setCustomAnimation(DescriptionAnimation())
        sliderLayout.setDuration(9000)
    }
}
