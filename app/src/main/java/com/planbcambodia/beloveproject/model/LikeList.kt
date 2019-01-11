package com.planbcambodia.beloveproject.model

class LikeList (var name:String, var isActive:Boolean, var time:String, var photo:Int){
    fun getUserName():String{
        return name;
    }
    fun getIsActive():Boolean{
        return isActive;
    }
    fun getUserTime():String{
        return time
    }
    fun getUserPhoto():Int{
        return photo
    }
}