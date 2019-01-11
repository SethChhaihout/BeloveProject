package com.planbcambodia.beloveproject.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.planbcambodia.beloveproject.intf.NetworkChangeListener

/**
 * Created by Panha Sakvisa on 1/8/2019.
 */
class NetworkChangeReceiver(val networkChangeListener:NetworkChangeListener): BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        try {
            val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetwork = cm.activeNetworkInfo
            val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
            networkChangeListener.onNetworkChange(isConnected)
        } catch (e: Exception) {
        }

    }
}