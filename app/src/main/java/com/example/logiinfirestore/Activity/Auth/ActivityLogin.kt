package com.example.logiinfirestore.Activity.Auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.logiinfirestore.Activity.ActivityBase
import com.example.logiinfirestore.Activity.Home.ActivityAbsen
import com.example.logiinfirestore.Model.User
import com.example.logiinfirestore.R
import com.google.firebase.firestore.FirebaseFirestore
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

class ActivityLogin : ActivityBase() {

    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

        daftar.setOnClickListener {
            val intent = Intent(this, ActivityRegister::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            login()
        }
    }

    fun init() {
        db = FirebaseFirestore.getInstance()

        Glide
                .with(this)
                .load(R.drawable.form_background)
                .centerCrop()
                .into(bglogin);
    }

    fun initdata() {

    }

    fun login() {
        button.isEnabled = false
        loadingLogin.visibility = View.VISIBLE
        val dbUser = db.collection("user")
        val email = Emaillogin.text.toString()
        val password = Passwordlogin.text.toString()

        dbUser.whereEqualTo("email", email).whereEqualTo("password", password).get()
                .addOnCompleteListener() {
                    button.isEnabled = true
                    loadingLogin.visibility = View.GONE
                }
                .addOnSuccessListener {
                    if (it.documents.isNotEmpty()) {
                        var data = it.documents.get(0)
                        var user = data.toObject(User::class.java)
                        user?.id = data.id
                        alert {
                            title = "Masuk berhasil"
                            message = "Lanjutkan untuk masuk aplikasi"
                            okButton {
                                goToAbsen()
                            }
                            Paper.book().write("user", user)
                            isCancelable = false
                        }.show()
                    } else {
                        showToast("Anda belum terdaftar, slahkan daftar terlebih dahulu")
                    }
                }
    }

    fun goToAbsen() {
        startActivity(Intent(ctx, ActivityAbsen::class.java))
        finish()
    }
}