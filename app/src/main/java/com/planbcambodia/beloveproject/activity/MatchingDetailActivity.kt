package com.planbcambodia.beloveproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.MatchingDetailAdapter
import kotlinx.android.synthetic.main.activity_matching_detail.*

class MatchingDetailActivity : AppCompatActivity() {
    var title = ArrayList<String>()
    var des = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matching_detail)

        btn_close_in_matching_detail.setOnClickListener {
            onBackPressed()
        }

        fillData()

        recyclerView_in_matching_detail.layoutManager = LinearLayoutManager(applicationContext)
        var adapter = MatchingDetailAdapter(title, des, this)
        recyclerView_in_matching_detail.adapter = adapter
        btn_arrow_down.setOnClickListener {
            recyclerView_in_matching_detail.smoothScrollToPosition(title.size - 1)
        }
        adapter.notifyDataSetChanged()
    }

    private fun fillData() {
        title.add("About me")
        title.add("Hobbies")
        title.add("Location")
        title.add("Height")
        title.add("Weight")
        title.add("Status")
        title.add("Smoking")
        title.add("Living")
        title.add("Alcohol")
        title.add("Work")

        des.add("User information about him or her. User information about him or her.")
        des.add("Coffee, Movie, Travel, Music, Dance, Gourmet, Cooking.....")
        des.add("Cambodia")
        des.add("170 cm")
        des.add("55 kg")
        des.add("Single")
        des.add("No")
        des.add("Alone")
        des.add("No")
        des.add("Rupp")
    }
}
