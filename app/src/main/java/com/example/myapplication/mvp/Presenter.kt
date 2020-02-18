package com.example.myapplication.mvp

interface Presenter {
    fun attachView(view: View)
    fun dispose()
}