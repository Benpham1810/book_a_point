package com.testone.book_a_point

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_email
import kotlinx.android.synthetic.main.activity_login.et_password
import kotlinx.android.synthetic.main.activity_login.btn_register

class LoginActivity : AppCompatActivity() {

        


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




        login.setOnClickListener {

            val email = et_email.text.toString()
            val password = et_password.text.toString()

            Log.d("LoginActivity","username: " + email)
            Log.d("LoginActivity", "password: $password")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener

                    Log.d("LoginActivity", "login account: ${it.result!!.user!!.uid}")
                intent = Intent( this, HomeActivity::class.java)
                    startActivity(intent)

                }
                .addOnFailureListener{

                    Log.d("LoginActivity", "login fail ${it.message}")
                       val text = "sorry couldn't find your account"
                            val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                }

        }

        btn_register.setOnClickListener {

            Log.d("LoginActivity","show sign up activity")
            //start sign  up activity
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

        signup_acc.setOnClickListener {

            Log.d("LoginActivity","show sign up activity")
            //show sign up activity
           val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

        forgot_Password.setOnClickListener {
            Log.d("LoginActivity", "show forgot password")
            //show forgot password activity
            val intent = Intent (this,ForgotPassword::class.java)
            startActivity(intent)

        }

    }
}
