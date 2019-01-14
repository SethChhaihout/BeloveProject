package com.planbcambodia.beloveproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.adapter.ForYourSafeAdapter
import com.planbcambodia.beloveproject.adapter.ReportAdapter
import com.planbcambodia.beloveproject.custom_layout.ExpandCollapseView
import kotlinx.android.synthetic.main.activity_faq.*

class FAQActivity : AppCompatActivity() {

    var questions = ArrayList<String>()
    var answers = ArrayList<String>()

    var questionsR = ArrayList<String>()
    var answersR = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        // Fill data to question and answer
        fillDataForYourSafe()

        // set up recycler view for your safe
        setUpRecyclerViewForYourSafe()

        // Fill data to Report
        fillDataReport()

        // set up recycler view report
        setUpRecyclerViewReport()

    }

    private fun fillDataReport() {
        questionsR.add(" Q. How can I manage about a users in BeLoves?")
        answersR.add("A. If you wish to report someone , please follow the instructions below : . visit the profile")
        questionsR.add(" Q. How can I manage about a users in BeLoves?")
        answersR.add("A. If you wish to report someone , please follow the instructions below : . visit the profile")
        questionsR.add(" Q. How can I manage about a users in BeLoves?")
        answersR.add("A. If you wish to report someone , please follow the instructions below : . visit the profile")
    }

    private fun setUpRecyclerViewReport() {
        recyclerView_report.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = ReportAdapter(questionsR, answersR, this, object  : ReportAdapter.OntxtQuestionClickListenerReport{
            override fun ontxtQuestion(item: String, view: ExpandCollapseView) {
                if (view.isExpanded){
                    view.collapse()
                }else{
                    view.expand()
                }
            }
        })
        recyclerView_report.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun setUpRecyclerViewForYourSafe() {
        recyclerView_for_safety.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = ForYourSafeAdapter(questions, answers, this, object : ForYourSafeAdapter.OntxtQuestionClickListenerFYS {
            override fun ontxtQuestion(item: String, view:ExpandCollapseView) {
                if (view.isExpanded){
                    view.collapse()
                }else{
                    view.expand()
                }
            }
        })
        recyclerView_for_safety.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun fillDataForYourSafe() {
        questions.add(" Q. How can I manage about my online safety?")
        answers.add("A. At BeLoves we take online security very seriously.At BeLoves we take online security very seriously.")
        questions.add(" Q. How can I manage about my online safety?")
        answers.add("A. At BeLoves we take online security very seriously.At BeLoves we take online security very seriously.")
        questions.add(" Q. How can I manage about my online safety?")
        answers.add("A. At BeLoves we take online security very seriously.At BeLoves we take online security very seriously.")
    }
}
