package com.example.logiinfirestore.Activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class ActivityBase :AppCompatActivity() {

    lateinit var ctx : Context
    lateinit var act : Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ctx = this
        act = this
    }
    fun showToast(s:String){
        Toast.makeText(this, s ,Toast.LENGTH_SHORT).show()
    }
}