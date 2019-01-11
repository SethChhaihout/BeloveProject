package com.planbcambodia.beloveproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search_filter.*
import me.tom.range.slider.RangeSliderView

class SearchFilterActivity : NetworkActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_filter)
        setBackable(true)

        slider.setRangeValues(ArrayList((18..70).toList()))
        slider.setMinAndMaxValue(18,70)

        slider.setOnValueChangedListener(object: RangeSliderView.OnValueChangedListener() {
            override fun onValueChanged(p0: Int, p1: Int) {
                age.text = "$p0- $p1"
            }
        })
    }
}
