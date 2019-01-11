package com.planbcambodia.belovecambodia.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.activity.BlockOrReport
import com.planbcambodia.beloveproject.model.ChatList
import kotlinx.android.synthetic.main.fragment_chat_list.view.*
import kotlinx.android.synthetic.main.viewholder_chat_list.view.*
import kotlinx.android.synthetic.main.yes_no_dialog.view.*

/**
 * Created by Srieng 21/12/2018
 */

class ChatListAdapter(
    val chatList: ArrayList<ChatList>,
    val context: Context,
    private var listener: OnChatClickListener
) : RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {


    open interface OnChatClickListener {
        fun OnChatListClick(item: ChatList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_chat_list, parent, false))
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList.get(position)
        Log.d("getName", "" + chat.getUserName())
        holder.tvName.setText(chat.getUserName())
        holder.tvLastMsg.setText(chat.getLastMessage())
        holder.imgUser.setImageResource(chat.getUserPhoto())
        if(chat.getIsActive()==true){
            holder.img_active.visibility=View.VISIBLE
        }else{
            holder.img_active.visibility=View.GONE
        }
        if(chat.getIsLike()==true){
            holder.img_star.setImageResource(R.drawable.img_star)
        }else{
            holder.img_star.setImageResource(R.drawable.img_star_blur)
        }


        holder.Bind(context,chatList.get(position), this.listener!!)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Holds the TextView that will add each animal to
        val imgUser=itemView.imgProfile
        val tvName = itemView.tvName
        val tvLastMsg = itemView.tvLastMessage
        val img_star = itemView.imv_star
        val lytSwipe = itemView.lytSwipe
        val img_active = itemView.imv_chat_active
        val lytBlockUser=itemView.lytBlockUser

        @SuppressLint("ClickableViewAccessibility")
        fun Bind(context: Context,chat: ChatList, listener: ChatListAdapter.OnChatClickListener) {

            tvName.text = chat.getUserName()
            tvLastMsg.text = chat.getLastMessage()

            img_star.setOnClickListener {
                if(chat.getIsLike()==true){
                    img_star.setImageResource(R.drawable.img_star_blur)
                }

                if(chat.getIsLike()==false){
                    img_star.setImageResource(R.drawable.img_star)
                }
            }

            lytBlockUser.setOnClickListener {
                Toast.makeText(context,"Block",Toast.LENGTH_SHORT).show()
                //Inflate the dialog with custom view
                val mDialogView = LayoutInflater.from(context).inflate(R.layout.yes_no_dialog, null)
                //AlertDialogBuilder
                val mBuilder = AlertDialog.Builder(context)
                        .setView(mDialogView)
                //show dialog

                val  mAlertDialog = mBuilder.show()
                     mAlertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                //login button click of custom layout
                mDialogView.tv_yes.setOnClickListener {
                    //dismiss dialog
                    mAlertDialog.dismiss()
                    startActivity(context,Intent(context,BlockOrReport::class.java),null)
                    //get text from EditTexts of custom layout
                    //val name = mDialogView.dialogNameEt.text.toString()
                }
                //cancel button click of custom layout
                mDialogView.tv_no.setOnClickListener {
                    //dismiss dialog
                    mAlertDialog.dismiss()
                }
            }

            lytSwipe.setOnTouchListener(object:View.OnTouchListener{
                var initX = 0f
                var initY = 0f
                var distanceY = 0f
                var distanceX = 0f
                var maxDistance = 100
                var isOpen = false
                val screenDpi = context.resources.displayMetrics.density
                var pressTime=0
                var eventTime=0
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    when(event?.action){
                        MotionEvent.ACTION_DOWN->{
                            //Toast.makeText(context,"DOWN",Toast.LENGTH_SHORT).show()
                            initX = event.rawX
                            initY = event.rawY
                            distanceY = 0f
                            distanceX = 0f
                            pressTime =event.downTime.toInt()

                            if(lytSwipe.translationX<0){
                                isOpen=true
                                img_star.visibility=View.VISIBLE
                            }else{
                                isOpen =false
                                img_star.visibility=View.GONE
                            }
                            lytSwipe.parent.requestDisallowInterceptTouchEvent(true)

                            if(event.downTime<5000){
                                Toast.makeText(context,"Click",Toast.LENGTH_SHORT).show()
                            }


                            return true
                        }

                        MotionEvent.ACTION_MOVE->{
                            distanceX = event.rawX - initX
                            distanceY = event.rawY - initY
                            //Toast.makeText(context,"MOVE",Toast.LENGTH_SHORT).show()
                            if(Math.abs(distanceY)>Math.abs(distanceX)){
                                img_star.visibility=View.VISIBLE
                                if(distanceX > -maxDistance*screenDpi/2){
                                    lytSwipe.animate().translationX(0f)
                                }else{
                                    lytSwipe.animate().translationX(-maxDistance*screenDpi)
                                }
                                lytSwipe.parent.requestDisallowInterceptTouchEvent(false)
                            }

                            if(!isOpen && distanceX<0 && distanceX>=-maxDistance*screenDpi){
                                lytSwipe.translationX = distanceX
                            }else if(isOpen && distanceX>0 && distanceX<=maxDistance*screenDpi){
                                lytSwipe.translationX = -60*screenDpi + distanceX
                            }
                            return true
                        }

                        MotionEvent.ACTION_UP->{
                            //Toast.makeText(context,"UP",Toast.LENGTH_SHORT).show()
                            eventTime=event.eventTime.toInt()
                            val holdTime = eventTime - pressTime
                            //Check duration for open chat activity
                            if (holdTime > 10 && holdTime <= 100) {
                                listener.OnChatListClick(chat)
                            }
                            if(distanceX > -maxDistance*screenDpi/2){
                                lytSwipe.animate().translationX(0f)
                                img_star.visibility=View.VISIBLE
                            }else{
                                lytSwipe.animate().translationX(-maxDistance*screenDpi)
                                img_star.visibility=View.GONE
                            }
                            return true
                        }
                    }

                    return true
                }
            })
        }
    }
}