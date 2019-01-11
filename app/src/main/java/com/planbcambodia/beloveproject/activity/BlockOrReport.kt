package com.planbcambodia.beloveproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.planbcambodia.beloveproject.R
import kotlinx.android.synthetic.main.activity_block_or_report.*
import android.widget.RadioButton
import android.widget.Toast


class BlockOrReport : AppCompatActivity() {
    /**
     * Created by HOM Srieng 01/09/2018 mm/dd/yyyy
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block_or_report)

        imv_back.setOnClickListener { finish() }
        tvSave.setOnClickListener{finish()}

        radioReport.clearCheck()
        radioReport.setOnCheckedChangeListener { group, checkedId ->
            val rb = group.findViewById(checkedId) as RadioButton
            if(null != rb && checkedId>-1){
                Toast.makeText(applicationContext,rb.text,Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun onClear(v : View){
        radioReport.clearCheck()
    }
}
