package com.example.testauthentication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.signup.*
import kotlinx.android.synthetic.main.signup.textViewSignUpLink

class SignUpActivity : AppCompatActivity() {
    //   private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  auth = Firebase.auth
        setContentView(R.layout.signup)
        textViewSignUpLink.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            //finish()
        }
    }
}