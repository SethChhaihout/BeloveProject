package com.planbcambodia.beloveproject

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.planbcambodia.beloveproject.model.Example
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
}