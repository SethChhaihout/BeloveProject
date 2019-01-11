package com.planbcambodia.beloveproject

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import android.view.Gravity
import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView



/**
* Created by chhaihout on 12/27/2018.
*/
open class BaseActivity : AppCompatActivity(){
    protected var disposable: CompositeDisposable? = null
    private var snakeBar:Snackbar? = null
    var screenDpi:Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disposable = CompositeDisposable()
        screenDpi = resources.displayMetrics.density
        //example get data
//        addDisposable(Example.getExamples()
//                .subscribe({response->
//                    if(response.success){
//                        for(example:Example in response.result){
//                            Log.d("Test",example.photo)
//                        }
//                    }
//                },{error->
//                    Log.d("Test",error.localizedMessage)
//                }))
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

    protected fun addDisposable(d:Disposable){
        disposable?.add(d)
    }

    fun showSnakebarNoConnection(){
        showSnakeBar(getString(R.string.connection_lost))
    }

    fun showSnakeBar(text:String){
        if(snakeBar != null){
            if(snakeBar!!.isShown){
                return
            }
        }

        snakeBar = Snackbar.make(findViewById(R.id.placeSnakebar), text, Snackbar.LENGTH_INDEFINITE)
        // get textview inside snackbar view
        val snackView:View = snakeBar!!.view
        val mTextView = snackView.findViewById<TextView>(android.support.design.R.id.snackbar_text)

        //set background color
        snackView.setBackgroundColor(ContextCompat.getColor(this, R.color.gray80))
        // set text to center
        mTextView.setLineSpacing(8*screenDpi,1f)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            mTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        else
            mTextView.gravity = Gravity.CENTER_HORIZONTAL

        snakeBar!!.show()
    }

    fun hideSnakeBar(){
        if(snakeBar!=null){
            snakeBar!!.dismiss()
        }
    }

    fun setBackable(backable:Boolean){
        if(backable){
            findViewById<View>(R.id.btnBack).setOnClickListener { v->
                finish()
            }
        }
    }
}