package com.sasaki.todo_app

import android.os.Bundle
import com.sasaki.todo_app.usecase.listener.NavigationBarListener
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<BottomNavigationView>(R.id.navigation).setOnNavigationItemSelectedListener(NavigationBarListener(supportFragmentManager))
    }
}
