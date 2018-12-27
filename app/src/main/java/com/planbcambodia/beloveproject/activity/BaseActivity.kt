package com.planbcambodia.beloveproject.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.planbcambodia.beloveproject.R

open class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    protected fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame,fragment)
                .commit()
    }
}