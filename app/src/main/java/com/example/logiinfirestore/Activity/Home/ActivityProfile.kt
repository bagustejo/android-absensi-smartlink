package com.example.logiinfirestore.Activity.Home

import android.content.Intent
import android.os.Bundle
import com.example.logiinfirestore.Activity.ActivityBase
import com.example.logiinfirestore.Activity.Auth.ActivityLogin
import com.example.logiinfirestore.Activity.Auth.ActivityRegister
import com.example.logiinfirestore.R
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_profile.*

class ActivityProfile : ActivityBase(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        logoutbutton.setOnClickListener {
            logout()
        }
    }

    fun logout(){
        GoToRegister()
        Paper.book().delete("user");
    }

    fun  GoToRegister(){
        startActivity(Intent(ctx, ActivityLogin::class.java))
        finish()
    }
}