package com.tranphuc.clean_demo

import android.app.Application
import com.tranphuc.di.KoinRunner

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinRunner.initDi(this)
    }
}