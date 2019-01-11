package com.planbcambodia.beloveproject.constant

import com.planbcambodia.beloveproject.model.Hobbie
import com.planbcambodia.beloveproject.model.ProfileItem
import com.planbcambodia.beloveproject.model.ProfilePhoto

/**
 * Created by Panha Sakvisa on 12/28/2018.
 */
class Constant{
    companion object {
        val BASE_URL = "http://ride-on.planbtesting.club/api/passenger/"
        val testProfileItem : ArrayList<ProfileItem> = arrayListOf(
                ProfileItem("Name","Rassy,25"),
                ProfileItem("About me","Add"),
                ProfileItem("Hobbies","Add"),
                ProfileItem("Location","Phnom Penh"),
                ProfileItem("Height","155 cm"),
                ProfileItem("Weight","55 kg"),
                ProfileItem("Status","Single"),
                ProfileItem("Smoking","No"),
                ProfileItem("Living","Alone"),
                ProfileItem("Alcohol","Drink")
        )

        val testProfilePhoto : ArrayList<ProfilePhoto> = arrayListOf(
                ProfilePhoto("aaaa"),
                ProfilePhoto("aaaa"),
                ProfilePhoto("aaaa"),
                ProfilePhoto("aaaa"),
                ProfilePhoto("aaaa"),
                ProfilePhoto("aaaa"),
                ProfilePhoto("aaaa"),
                ProfilePhoto("aaaa"),
                ProfilePhoto("aaaa")
        )

        val testHobbie : ArrayList<Hobbie> = arrayListOf(
                Hobbie("No answer",isSelected = true),
                Hobbie("Coffee"),
                Hobbie("Sport"),
                Hobbie("Movie"),
                Hobbie("Travel"),
                Hobbie("Music"),
                Hobbie("Dance"),
                Hobbie("Cooking")
        )
    }
}