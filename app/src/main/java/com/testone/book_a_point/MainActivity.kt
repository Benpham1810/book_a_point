package com.testone.book_a_point

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//start register activity
    create_account_btn.setOnClickListener {
        Log.d("MainActivity", "open register")

        //start Register activity

        val intent = Intent (this, RegisterActivity::class.java)
        startActivity(intent)


    }


    loginacc_txt.setOnClickListener {

        Log.d("MainActivity","start login activity")
        //start login activity

      val  intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)

    }
        //start login activity
    login_acc_txt.setOnClickListener {

        Log.d("MainActivity", "show LoginActivity")

        //show login activity
    val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }

    }
}
