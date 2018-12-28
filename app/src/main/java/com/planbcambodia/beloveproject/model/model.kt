package com.planbcambodia.beloveproject.model

import com.planbcambodia.beloveproject.api.RequestInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Panha Sakvisa on 12/28/2018.
 */

data class Example(var id:Int,var name:String?){
    companion object {
        fun getExamples():Observable<List<Example>>{
            return RequestInterface.requestInterface.getData()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
        }
    }
}