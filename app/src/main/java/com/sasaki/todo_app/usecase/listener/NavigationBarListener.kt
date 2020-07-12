package com.sasaki.todo_app.usecase.listener


import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sasaki.todo_app.R
import com.sasaki.todo_app.controller.fragment.RemindFragment
import com.sasaki.todo_app.controller.fragment.TodoFragment

class NavigationBarListener(supportFragmentManager: FragmentManager) : BottomNavigationView.OnNavigationItemSelectedListener {
    private val fragmentManager = supportFragmentManager
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_todo -> {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, TodoFragment())
                        .commit()
                return true
            }
            R.id.navigation_calendar -> {
                return true
            }
            R.id.navigation_remind -> {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, RemindFragment())
                        .commit()
                return true
            }
        }
        return false
    }
}