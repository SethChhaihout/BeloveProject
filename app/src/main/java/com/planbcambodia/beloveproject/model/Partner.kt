package com.planbcambodia.beloveproject.model

class Partner(var partnerId: String,var partnerName : String,partnerPhoto: String){

    fun Partner(){

    }
    fun getId(): String{
        return partnerId
    }
    fun getName():String {
        return partnerName
    }
    fun getPhoto(): String {
        return partnerName;
    }
}