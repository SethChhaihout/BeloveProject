package com.planbcambodia.beloveproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.planbcambodia.beloveproject.R
import com.planbcambodia.beloveproject.fragment.FragmentBlockedUsersEmpty
import com.planbcambodia.beloveproject.fragment.FragmentBlockedUsersList
import kotlinx.android.synthetic.main.activity_blocked_users.*

class BlockedUsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blocked_users)
        imv_back.setOnClickListener { finish() }

        val fragmentBlockedUsersEmpty = FragmentBlockedUsersEmpty()
        val fragmentBlockedUsersList  = FragmentBlockedUsersList()

        fragmentBlockedUsersEmpty.arguments = intent.extras
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentBlockUser, fragmentBlockedUsersList)
        transaction.commit()
    }
}
