package com.testone.book_a_point


import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
     runRegister()

        already_have_acc.setOnClickListener {
            Log.d("RegisterActivity", "show login activity")
            //launch login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        have_acc.setOnClickListener {
            Log.d("RegisterActivity", "show login activity")
            //Also launch login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) }

        runRegister()
    }

    private fun runRegister(){

        btn_register.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            Log.d("RegisterActivity", "email:  $et_email")
            Log.d("RegisterActivity", "password: $et_password")



                    if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this,"Missing Email and Password",Toast.LENGTH_SHORT).show()
              return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                    if (!it.isSuccessful) return@addOnCompleteListener
                    Log.d("Main", "Successfully created uid: ${it.result!!.user!!.uid}")
                btn_register.setOnClickListener {



                    intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                Toast.makeText(this,"wellcome",Toast.LENGTH_SHORT).show()

                }

                }
                .addOnFailureListener {
                    Log.d("Register","fail to create ${it.message}")
                }
        }

    }


}