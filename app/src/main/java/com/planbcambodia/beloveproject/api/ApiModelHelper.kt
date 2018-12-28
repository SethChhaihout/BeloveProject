package com.planbcambodia.beloveproject.api

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Panha Sakvisa on 12/28/2018.
 */
class ApiModelHelper{
    companion object {
        fun <T>observe(observable: Observable<T>):Observable<T>{
            return observable
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
        }
    }
}