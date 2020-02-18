package com.example.myapplication

import android.util.Log

//import dagger.Component
//import javax.inject.Inject
//
//class A @Inject constructor(private val b:B){
//    fun run(){
//        println("chạy..........")
//    }
//}
//
//class B @Inject constructor(){
//    fun say(){
//        print("xin chào")
//    }
//}
//@Component
//interface myComponent{
//    fun getA():A
//}
//
//fun main() {
//    val myComponent = DaggermyComponent.builder().build()
//    val b = myComponent.getA()
//
//}
interface B{
    fun C(){
        print("adfhkaskhj")
    }
}
class A : B{
    override fun C() {
        print("f")
    }
}
fun main() {
    var a=A()
    a.C()
}