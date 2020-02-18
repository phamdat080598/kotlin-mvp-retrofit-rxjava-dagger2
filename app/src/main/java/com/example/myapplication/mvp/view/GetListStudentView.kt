package com.example.myapplication.mvp.view

import com.example.myapplication.mvp.View
import com.example.myapplication.mvp.model.hocsinh

interface GetListStudentView: View{
    fun showListStudent(listStudent: List<hocsinh>)
}