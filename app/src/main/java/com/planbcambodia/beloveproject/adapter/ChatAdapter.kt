package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.text.ParseException
import java.util.*
import android.widget.LinearLayout
import android.widget.TextView
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.model.Chat
import com.planbcambodia.beloveproject.model.Partner
import com.planbcambodia.beloveproject.model.User
import com.planbcambodia.beloveproject.constant.Utils
import de.hdodenhof.circleimageview.CircleImageView




class ChatAdapter(
        val chats: ArrayList<Chat>,
        val context: Context
) : RecyclerView.Adapter<ChatAdapter.ChatTextViewHolder>() {


    private val CHAT_TEXT_SENDER = 1
    private val CHAT_TEXT_RECEIVER = 2
    private val CHAT_IMAGE_SENDER = 3
    private val CHAT_IMAGE_RECEIVER = 4
    var parent: ViewGroup? = null
    var user: User = User("1","Srieng","url")
    var partner: Partner = Partner("2","Thina","Url")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatTextViewHolder {
        var view: View? = null
        this.parent = parent
        if (viewType == CHAT_TEXT_SENDER) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_chat_text_sender, parent, false)
        } else if (viewType == CHAT_TEXT_RECEIVER) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_chat_text_receiver, parent, false)
        } else if (viewType == CHAT_IMAGE_SENDER) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_chat_image_sender, parent, false)
        } else if (viewType == CHAT_IMAGE_RECEIVER) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_chat_image_receiver, parent, false)
        }

        return ChatTextViewHolder(view!!)

    }

    override fun getItemViewType(position: Int): Int {
        return if (chats[position].getUser_id() == partner.getId().toString()) {
            if (chats.get(position).getType()?.getId() == 1) {
                CHAT_TEXT_SENDER
            } else {
                CHAT_IMAGE_SENDER
            }
        } else {
            if (chats[position].getType()?.getId() == 2) {
                CHAT_TEXT_RECEIVER
            } else {
                CHAT_IMAGE_RECEIVER
            }
        }
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    override fun onBindViewHolder(holder: ChatTextViewHolder, position: Int) {
        if (chats.get(position).getType()?.getId() == 1) {
            holder.bindText(user, chats.get(position), partner)
        } else {
            holder.bindImage(chats.get(position), user, partner, parent!!.context)
        }
    }

    class ChatTextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var imgProfile: CircleImageView? = null
        private var txtChat: TextView? = null
        private var txtTime: TextView? = null
        private var lytTimestamp: LinearLayout? = null
        private var image: ImageView? = null

        fun ChatTextViewHolder(itemView: View) {
            super.itemView
            imgProfile = itemView.findViewById(R.id.img_profile);
            txtChat = itemView.findViewById(R.id.txt_chat);
            txtTime = itemView.findViewById(R.id.txt_time);
            lytTimestamp = itemView.findViewById(R.id.timestamp);
            image = itemView.findViewById(R.id.image);
        }

        fun bindText(user: User, chat: Chat, partner: Partner) {
            if (chat.isShowTimeStamp()==true) {
                try {
                    txtTime?.text = Utils.formatDate(chat.getSent_date().toString(), "yyyy-MM-dd HH:mm:ss", "hh:mm a")
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

            } else {
                txtTime?.visibility = View.GONE
            }

            if (chat.getUser_id()!!.equals(user.getId())) {
                /*Picasso.get()
                    .load(Utils.convertImagePath(user.getPhoto()))
                    .placeholder(R.drawable.dummy_profile)
                    .fit()
                    .centerCrop()
                    .into(imgProfile)*/
            } else {
                /*Picasso.get()
                    .load(Utils.convertImagePath(partner.getPhoto()))
                    .placeholder(R.drawable.dummy_profile)
                    .fit()
                    .centerCrop()
                    .into(imgProfile)*/
            }
            txtChat?.text = chat.getType()?.getText()
        }

        fun bindImage(chat: Chat, user: User, partner: Partner, context: Context) {
            if (chat.isShowTimeStamp()==true) {
                try {
                        txtTime?.text = Utils.formatDate(chat.getSent_date().toString(), "yyyy-MM-dd HH:mm:ss", "hh:mm a")
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

            } else {
                txtTime?.visibility = View.GONE
            }

            if (!TextUtils.isEmpty(chat.getType()?.getUrl())) {
                Picasso.get()
                    .load(chat.getType()!!.getUrl())
                    .centerCrop()
                    .fit()
                    .into(image)

                if (image != null) {
                    image?.setOnClickListener(object:View.OnClickListener {
                        override fun onClick(v: View?) {
                            //val intent = Intent(context, PreviewImageActivity::class.java)
                            //intent.putExtra("url", chat.getType()!!.getUrl())
                            //context.startActivity(intent)
                        }

                    })
                }
            }

            if (chat.getUser_id()!!.equals(user.getId())) {
                /*Picasso.get()
                    .load(Utils.convertImagePath(user.getPhoto()))
                    .placeholder(R.drawable.dummy_profile)
                    .fit()
                    .centerCrop()
                    .into(imgProfile)*/
            } else {
                /*Picasso.get()
                    .load(Utils.convertImagePath(partner.getPhoto()))
                    .placeholder(R.drawable.dummy_profile)
                    .fit()
                    .centerCrop()
                    .into(imgProfile)*/
            }
        }
    }
}