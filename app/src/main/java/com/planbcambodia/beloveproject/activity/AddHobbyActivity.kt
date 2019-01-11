package com.planbcambodia.beloveproject.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.planbcambodia.beloveproject.R
import kotlinx.android.synthetic.main.activity_add_hobby.*

class AddHobbyActivity : NetworkActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_hobby)

        setBackable(true)

        save.setOnClickListener { v->
            val intent = Intent()
            intent.putExtra("name",hobbieName.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
