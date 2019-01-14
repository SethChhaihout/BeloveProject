package com.planbcambodia.beloveproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.custom_layout.ExpandCollapseView
import kotlinx.android.synthetic.main.custom_item_faq.view.*

/**
 * Created by chhaihout on 1/14/2019.
 */
class ForYourSafeAdapter(var questions : ArrayList<String>, var answers : ArrayList<String>, val context: Context,
                         val ontxtQuestionClickListener :OntxtQuestionClickListenerFYS) : RecyclerView.Adapter<ForYourSafeAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.txtQuestion.text = questions[position]
//        holder.txtAnswer.text = answers[position]
        holder.bindView(questions[position], ontxtQuestionClickListener)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.custom_item_faq, parent, false)
        return MyViewHolder(v)
    }


    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtQuestion = view.txtQ
        val txtAnswer = view.txtAns
        fun bindView(item: String, ontxtQuestionClickListener: OntxtQuestionClickListenerFYS){
            txtQuestion.setOnClickListener {
                ontxtQuestionClickListener.ontxtQuestion(item,itemView.ExpandAns)
            }
        }
    }

    interface OntxtQuestionClickListenerFYS{
        fun ontxtQuestion(item: String, view:ExpandCollapseView)
    }
}

