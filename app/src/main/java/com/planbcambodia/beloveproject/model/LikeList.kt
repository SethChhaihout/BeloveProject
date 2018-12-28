package com.planbcambodia.beloveproject.model

class LikeList (var name:String, var age:String, var location:String, var photo:String){
    fun getUserName():String{
        return name;
    }
    fun getUserAge():String{
        return age;
    }
    fun getUserLocation():String{
        return location
    }
    fun getUserPhoto():String{
        return photo
    }
}