package com.planbcambodia.beloveproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.planbcambodia.beloveproject.R
import kotlinx.android.synthetic.main.activity_company_profile.*

class CompanyProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_profile)

        imv_back.setOnClickListener { finish() }

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView!!.loadUrl("https://policies.google.com/faq?hl=en")
    }
}
