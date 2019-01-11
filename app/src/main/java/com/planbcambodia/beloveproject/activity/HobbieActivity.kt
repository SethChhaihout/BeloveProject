package com.planbcambodia.beloveproject.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.HobbieAdapter
import com.planbcambodia.beloveproject.constant.Constant
import com.planbcambodia.beloveproject.model.Hobbie
import kotlinx.android.synthetic.main.activity_hobbie.*

class HobbieActivity : NetworkActivity() {
    val REQUEST_ADD_HOBBIE = 111
    lateinit var adapter:HobbieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbie)

        setBackable(true)

        adapter = HobbieAdapter(Constant.testHobbie)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        save.setOnClickListener { v->
            finish()
        }

        lytBtnAdd.setOnClickListener { v->
            startActivityForResult(Intent(this,AddHobbyActivity::class.java),REQUEST_ADD_HOBBIE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_ADD_HOBBIE && resultCode == Activity.RESULT_OK){
            if (data != null) {
                Constant.testHobbie.add(Hobbie(data.getStringExtra("name"),true))
                adapter.notifyDataSetChanged()
                lytBtnAdd.visibility = View.GONE
            }
        }
    }
}
