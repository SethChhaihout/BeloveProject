package com.planbcambodia.beloveproject.util

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import com.planbcambodia.beloveproject.R
import kotlinx.android.synthetic.main.dialog_call.view.*

/**
 * Created by Panha Sakvisa on 1/8/2019.
 */
class Dialog{
    companion object {
        fun dialogCall(context:Context,onCallClick: View.OnClickListener,onCancelClick: View.OnClickListener):AlertDialog{
            val builder = AlertDialog.Builder(context)
            val view = LayoutInflater.from(context).inflate(R.layout.dialog_call,null)
            builder.setView(view)
            view.call.setOnClickListener { it->
                onCallClick.onClick(it)
            }
            view.cancel.setOnClickListener { it->
                onCancelClick.onClick(it)
            }

            val alertDialog = builder.create()
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            return alertDialog
        }
    }
}