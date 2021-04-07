package com.example.myapplicationtest.base

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import javax.inject.Inject

open class BaseViewModel:ViewModel() {



    fun isInternetConnected( application: Application): Boolean {
        val conMgr =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        return if (netInfo == null) false else true
    }
}