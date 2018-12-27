package com.planbcambodia.beloveproject

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by chhaihout on 12/27/2018.
 */
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