package com.testone.book_a_point

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
    item -> when(item.itemId){
        R.id.home -> {
         // all the home page is here
          replaceFragment(HomeFragment())
            println("Home activity")
            return@OnNavigationItemSelectedListener true
        }
        R.id.map -> {
            replaceFragment(MapFragment())
            println("Map activity")
            return@OnNavigationItemSelectedListener true
        }
        R.id.inbox -> {
            replaceFragment(InboxFragment())
            println("Inbox activity")
            return@OnNavigationItemSelectedListener true
        }
        R.id.appointment -> {
            replaceFragment(AppointmentFragment())
            println("appointment activity")
            return@OnNavigationItemSelectedListener true
        }
        R.id.profile -> {
            replaceFragment(ProfileFragment())
            println("Profile activity")
            return@OnNavigationItemSelectedListener true
        }
    }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener)
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
