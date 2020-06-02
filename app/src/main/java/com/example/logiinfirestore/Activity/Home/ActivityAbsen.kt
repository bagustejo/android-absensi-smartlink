package com.example.logiinfirestore.Activity.Home

import android.content.Intent
import android.os.Bundle
import com.example.logiinfirestore.Activity.ActivityBase
import com.example.logiinfirestore.Activity.Auth.ActivityRegister
import com.example.logiinfirestore.R
import kotlinx.android.synthetic.main.activity_absen.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.AsyncTask
import android.view.View
import com.esotericsoftware.kryo.util.IntArray
import com.example.logiinfirestore.Model.User
import com.google.firebase.firestore.FirebaseFirestore
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.vibrator
import java.util.*


class ActivityAbsen : ActivityBase(){

    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen)

        init()
        initdata()

    }

    fun init(){


        db = FirebaseFirestore.getInstance()

        profile_manager.setOnClickListener {
            val intent = Intent(this, ActivityProfile::class.java)
            startActivity(intent)
        }

        b_absen.setOnClickListener {
            absen()
        }

    }

    fun initdata(){

    }


    fun absen(){

        val intent = Intent(this, ActivityPhoto::class.java)
        startActivity(intent)

//        b_absen.isEnabled = false
//        loadingAbsen.visibility = View.VISIBLE
//        val dbAbsen = db.collection("absen")

    }

}