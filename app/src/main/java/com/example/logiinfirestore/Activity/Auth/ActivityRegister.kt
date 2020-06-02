package com.example.logiinfirestore.Activity.Auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.logiinfirestore.Activity.ActivityBase
import com.example.logiinfirestore.Model.User
import com.example.logiinfirestore.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import java.util.*

class ActivityRegister : ActivityBase() {

    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
        initdata()


    }

    fun init() {
        db = FirebaseFirestore.getInstance()

        Glide
                .with(this)
                .load(R.drawable.form_background)
                .centerCrop()
                .into(bg);

        masuk.setOnClickListener {
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)

        }

        buttonRegister.setOnClickListener {
            register()
        }
    }

    fun initdata() {

    }

    fun register() {
        buttonRegister.isEnabled = false
        loading.visibility = View.VISIBLE
        val dbUser = db.collection("user")
        val password = Password.text.toString()
        val ulangPassword = ulangPassword.text.toString()

        if (!password.equals(ulangPassword)) {
            showToast("Password Sala(TIDAK SAMA)")
            buttonRegister.isEnabled = true
            loading.visibility = View.GONE
            return
        }

        val email = Email.text.toString()

        dbUser.whereEqualTo("email", email).get()
                .addOnCompleteListener {
                    buttonRegister.isEnabled = true
                    loading.visibility = View.GONE
                }
                .addOnSuccessListener {
                    if (it.documents.isEmpty()) {
                        var id = UUID.randomUUID().toString()
                        var data = User(id, Personalname.text.toString(), Jabatan.text.toString(), email, password, status = false)
                        dbUser.document(id).set(data)
                        alert {
                            title = "Pendaftaran berhasil"
                            message = "Akun anda sudah resmi terdaftar. Silakan Login untuk melanjutkan"
                            okButton {
                                goToLogin()
                            }
                            isCancelable = false
                        }.show()
                    } else {
                        showToast("Email telah digunakan, silahkan menggunakan email lain")
                    }
                }
    }

    fun goToLogin() {
        startActivity(Intent(ctx, ActivityLogin::class.java))
        finish()
    }
}