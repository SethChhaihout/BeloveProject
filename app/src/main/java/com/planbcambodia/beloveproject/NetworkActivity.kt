package com.planbcambodia.beloveproject

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import com.planbcambodia.beloveproject.intf.NetworkChangeListener
import com.planbcambodia.beloveproject.service.NetworkChangeReceiver

/**
 * Created by Panha Sakvisa on 1/8/2019.
 */
open class NetworkActivity:BaseActivity(),NetworkChangeListener{
    var networkChangeReceiver:NetworkChangeReceiver? = null

    override fun onNetworkChange(isConnected: Boolean) {
        if(isConnected){
            hideSnakeBar()
        }else{
            showSnakebarNoConnection()
        }
    }

    override fun onResume() {
        super.onResume()
        networkChangeReceiver = NetworkChangeReceiver(this)
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(networkChangeReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkChangeReceiver)
    }
}