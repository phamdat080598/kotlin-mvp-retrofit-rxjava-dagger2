package com.example.myapplication.mvp.presenter

import android.util.Log
import com.example.myapplication.api.APIService
import com.example.myapplication.api.Client
import com.example.myapplication.mvp.Presenter
import com.example.myapplication.mvp.View
import com.example.myapplication.mvp.model.hocsinh
import com.example.myapplication.mvp.view.GetListStudentView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class GetListStudentPresenter @Inject constructor(var retrofit:Retrofit): Presenter {
    lateinit var view:GetListStudentView
    lateinit var compositeDisposable: CompositeDisposable
    init {
        compositeDisposable = CompositeDisposable()
    }
    override fun attachView(view: View) {
        this.view = view as GetListStudentView
    }

    override fun dispose() {
        compositeDisposable.dispose()
    }

    fun getListStudent(){
        compositeDisposable.add(retrofit.create(APIService::class.java).getListStudent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {list->showListStudent(list)},
                { error ->  showError(error,"lỗi rồi!!!!!!!!")}
            )
        )
    }

    fun showListStudent(list: List<hocsinh>){
        if(!list.isEmpty()){
            view.showListStudent(list)
        }
    }

    fun showError(throwable: Throwable,message: String){
        Log.d("ahihihi",throwable.message)
        view.showError(message)
    }
}