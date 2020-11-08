package com.example.testauthentication

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var user: FirebaseUser? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSignUp.setOnClickListener {
            (this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(it.windowToken, 0)

            if (editTextEmail.text.toString().isNullOrEmpty() || editTextPassword.text.toString()
                            .isNullOrEmpty())
                textViewResponse.text = "Email Address or Password is not provided"
            else {
                auth.signInWithEmailAndPassword(
                        editTextEmail.text.toString(),
                        editTextPassword.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                textViewResponse.text =
                                        "Sign Up successfull. Email and Password created"
                                 user = auth.currentUser
                                updateUI(user)
                            } else {
                                textViewResponse.text = "Sign Up Failed"
                                updateUI(null)
                            }
                        }
            }
        }
    }
    private fun updateUI(currentUser: FirebaseUser?) {

    }
}
