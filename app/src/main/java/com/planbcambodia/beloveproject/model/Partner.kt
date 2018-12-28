package com.planbcambodia.beloveproject.model

class Partner{
    var partnerId : Int=0
    var partnerName : String =""
    var partnerPhoto : String=""
    fun Partner(){

    }
    fun getId(): Int{
        return partnerId
    }
    fun getName():String {
        return partnerName
    }
    fun getPhoto(): String {
        return partnerPhoto;
    }
}