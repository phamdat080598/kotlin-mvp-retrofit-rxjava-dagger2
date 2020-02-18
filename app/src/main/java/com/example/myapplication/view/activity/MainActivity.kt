package com.example.myapplication.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.app.MyApplication
import com.example.myapplication.listener.ItemListener
import com.example.myapplication.mvp.model.hocsinh
import com.example.myapplication.mvp.presenter.GetListStudentPresenter
import com.example.myapplication.mvp.view.GetListStudentView
import com.example.myapplication.view.adapter.MyAdapter
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(),ItemListener,GetListStudentView{

    private lateinit var myAdapter:MyAdapter
    @Inject
    lateinit var presenter : GetListStudentPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //(applicationContext as MyApplication).getMyComponent().inject(this)
        MyApplication().getMyComponent().inject(this)
        myAdapter = MyAdapter(this)
        recycleView.layoutManager=LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)
        recycleView.adapter = myAdapter

        createPresenter()
    }
    fun createPresenter(){
        presenter.attachView(this)
        presenter.getListStudent()
    }
    override fun onListen(hs: hocsinh) {
        Toast.makeText(this@MainActivity,"${hs.id} ------ ${hs.name}",Toast.LENGTH_SHORT).show()
    }

    override fun showListStudent(listStudent: List<hocsinh>) {
        myAdapter.submitList(listStudent)
        Toast.makeText(this@MainActivity,"${listStudent.size}+ahihihi",Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(this@MainActivity,error,Toast.LENGTH_SHORT).show()
    }
}