package com.planbcambodia.beloveproject.model

class User (){
    var userId : Int = 0
    var userName : String = ""
    var userPhoto: String = ""

    fun getId() : Int{
        return userId
    }
    fun getName() : String{
        return userName
    }
    fun getPhoto():String {
        return userPhoto
    }
}