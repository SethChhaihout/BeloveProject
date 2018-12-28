package com.planbcambodia.beloveproject.model

class ChatList(var name: String, var photo: String, var last_message: String, var time: String) {

    fun getUserName(): String {
        return name
    }

    fun getUserPhoto(): String {
        return photo
    }

    fun getLastMessage(): String {
        return last_message;
    }

    fun getUserTime(): String {
        return time
    }
}