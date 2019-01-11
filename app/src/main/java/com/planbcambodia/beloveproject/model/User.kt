package com.planbcambodia.beloveproject.model

class User (var userId : String,var userName: String,var userPhoto:String){
    fun User(){

    }
    fun getId() : String{
        return userId
    }
    fun getName() : String{
        return userName
    }
    fun getPhoto():String {
        return userPhoto
    }
}