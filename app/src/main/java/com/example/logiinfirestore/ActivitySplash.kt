package com.example.logiinfirestore

import androidx.appcompat.app.AppCompatActivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

import com.example.logiinfirestore.R
import com.example.logiinfirestore.Activity.Auth.ActivityLogin
import com.example.logiinfirestore.Activity.Auth.ActivityRegister
import com.example.logiinfirestore.Activity.Home.ActivityAbsen
import com.example.logiinfirestore.Model.User
import io.paperdb.Paper
import org.jetbrains.anko.email

class ActivitySplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            var user = Paper.book().read<User>("user")
            if (user != null){
                // go to absen
                val lanjut = Intent(this@ActivitySplash, ActivityAbsen::class.java)
                startActivity(lanjut)
            } else {
                val selesai = Intent(this@ActivitySplash, ActivityRegister::class.java)
                startActivity(selesai)

                finish()
            }

        }, 1500)



    }
}
