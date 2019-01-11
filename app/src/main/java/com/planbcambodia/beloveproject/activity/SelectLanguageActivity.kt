package com.planbcambodia.beloveproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.planbcambodia.beloveproject.R
import kotlinx.android.synthetic.main.activity_select_language.*

class SelectLanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_language)

        imv_back.setOnClickListener { finish() }

    }
}
