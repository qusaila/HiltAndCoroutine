package com.example.hiltwithroomandcoroutine.listeners

interface ResponseListener {
    fun sucess(obj:Any)
fun error(msg:String)
    fun loading()
}