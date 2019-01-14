package com.planbcambodia.beloveproject.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.planbcambodia.beloveproject.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
* Created by chhaihout on 12/27/2018.
*/
open class BaseActivity : AppCompatActivity(){
    protected var disposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disposable = CompositeDisposable()

    }

    protected fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame,fragment)
                .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.clear()
    }
}