package com.planbcambodia.beloveproject.model

class ChatType (var userId: Int,var userText : String){

    fun ChatType(){

    }
    var userUrl: String=""
    fun ChatType(userId: Int, userText: String){

    }

    fun getUrl(): String? {
        return userUrl
    }

    fun setUrl(url: String) {
        this.userUrl = url
    }

    fun getId(): Int {
        return userId
    }

    fun setId(id: Int) {
        this.userId = id
    }

    fun getText(): String? {
        return userText
    }

    fun setText(text: String) {
        this.userText = text
    }
}