package com.planbcambodia.beloveproject.api

import com.planbcambodia.beloveproject.constant.Constant
import com.planbcambodia.beloveproject.model.BaseModel
import com.planbcambodia.beloveproject.model.Example
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Panha Sakvisa on 12/28/2018.
 */
interface RequestInterface{
    @GET("service")
    fun getData():Observable<BaseModel<List<Example>>>

    companion object {
        val requestInterface = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface::class.java)
    }
}