package com.example.myapplication.api

import com.example.myapplication.mvp.model.hocsinh
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {

    @GET("gethocsinh.php")
    fun getListStudent () : Observable<List<hocsinh>>
}