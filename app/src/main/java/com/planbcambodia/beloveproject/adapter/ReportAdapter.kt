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
class ReportAdapter(var questionsR : ArrayList<String>, var answersR : ArrayList<String>, val context: Context,
                         val ontxtQuestionClickListenerReport :OntxtQuestionClickListenerReport) : RecyclerView.Adapter<ReportAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(questionsR[position], ontxtQuestionClickListenerReport)
    }

    override fun getItemCount(): Int {
        return questionsR.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportAdapter.MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.custom_item_faq, parent, false)
        return MyViewHolder(v)
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtQuestion = view.txtQ
        val txtAnswer = view.txtAns
        fun bindView(item: String, ontxtQuestionClickListener: OntxtQuestionClickListenerReport){
            txtQuestion.setOnClickListener {
                ontxtQuestionClickListener.ontxtQuestion(item,itemView.ExpandAns)
            }
        }
    }

    interface OntxtQuestionClickListenerReport{
        fun ontxtQuestion(item: String, view:ExpandCollapseView)
    }
}

