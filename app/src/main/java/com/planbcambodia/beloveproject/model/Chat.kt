package com.planbcambodia.beloveproject.model

class Chat (var timeStamp: Boolean?, var sendDate: String, var userId: String,var partnerId : Int, var chatType: ChatType){

    fun isShowTimeStamp(): Boolean? {
        return timeStamp
    }

    fun setShowTimeStamp(showTimeStamp: Boolean) {
        this.timeStamp = showTimeStamp
    }

    fun getSent_date(): String? {
        return sendDate
    }

    fun setSent_date(sent_date: String) {
        this.sendDate = sent_date
    }

    fun getUser_id(): String? {
        return userId
    }

    fun setUser_id(user_id: String) {
        this.userId = user_id
    }

    fun getType(): ChatType? {
        return chatType
    }

    fun setType(type: ChatType) {
        this.chatType = type
    }
}