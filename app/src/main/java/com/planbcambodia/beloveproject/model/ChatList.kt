package com.planbcambodia.beloveproject.model

class ChatList(var name: String, var photo: Int, var last_message: String,var isLike : Boolean,var isActive : Boolean) {

    fun getUserName(): String {
        return name
    }

    fun getUserPhoto(): Int {
        return photo
    }

    fun getLastMessage(): String {
        return last_message;
    }

    fun getIsLike() : Boolean{
        return isLike
    }
    fun getIsActive() : Boolean{
        return isActive
    }
}