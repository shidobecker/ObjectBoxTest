package br.com.objectboxtest

import android.app.Application

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }


}