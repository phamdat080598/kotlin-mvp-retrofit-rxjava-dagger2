package com.example.myapplication.di.Component

import com.example.myapplication.di.Module.MyModule
import com.example.myapplication.view.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[MyModule::class])
interface MyComponent {
    fun inject(main: MainActivity)
}