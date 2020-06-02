package com.example.logiinfirestore.Model

import android.provider.ContactsContract

data class User(var id: String, var name: String, var jabatan: String, var email: String, var password: String, var status: Boolean){
    constructor():this("","","","","",false)
    constructor(id:String):this(id,"","","","",false)
}
