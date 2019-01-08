package com.planbcambodia.beloveproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.planbcambodia.beloveproject.BaseActivity
import com.planbcambodia.beloveproject.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.*

/**
 * Created by Panha Sakvisa on 12/28/2018.
 */
open class BaseFragment: Fragment() {
    protected var disposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disposable = CompositeDisposable()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
        disposable?.clear()
    }

    protected fun addDisposable(d: Disposable){
        disposable?.add(d)
    }

    fun showSnakebarNoConnection(){
        showSnakeBar(getString(R.string.connection_lost))
    }

    fun showSnakeBar(text:String){
        (activity as BaseActivity).showSnakeBar(text)
    }
}