package com.example.value

import android.app.Application
import com.example.value.di.AppComponent
import com.example.value.di.CoreModule
import com.example.value.di.DaggerAppComponent

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .core(CoreModule(this))
            .build()
        appComponent.inject(this)
    }

}