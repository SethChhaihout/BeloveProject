package com.planbcambodia.beloveproject.model

import com.planbcambodia.beloveproject.api.ApiModelHelper
import com.planbcambodia.beloveproject.api.RequestInterface
import io.reactivex.Observable

/**
 * Created by Panha Sakvisa on 12/28/2018.
 */
data class BaseModel<T>(var success:Boolean,var status:Int,var message:String,var result:T)

data class Example(var id:Int,var service_name:String?,var photo:String?){
    companion object {
        fun getExamples():Observable<BaseModel<List<Example>>>{
            return ApiModelHelper.observe(RequestInterface.requestInterface.getData())
        }
    }
}