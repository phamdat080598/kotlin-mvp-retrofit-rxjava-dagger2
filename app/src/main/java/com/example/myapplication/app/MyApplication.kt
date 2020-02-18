package com.example.myapplication.app

import android.app.Application
import com.example.myapplication.di.Component.DaggerMyComponent
import com.example.myapplication.di.Component.MyComponent

class MyApplication: Application() {
    private lateinit var myComponent : MyComponent
    override fun onCreate() {
        super.onCreate()
        myComponent = DaggerMyComponent.create()
    }
    fun getMyComponent(): MyComponent{
        return myComponent
    }

}