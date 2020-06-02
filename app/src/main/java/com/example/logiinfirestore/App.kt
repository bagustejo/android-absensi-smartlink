package com.example.logiinfirestore

import android.app.Application
import io.paperdb.Paper

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }
}