package com.sasaki.todo_app.controller.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sasaki.todo_app.R

class CommonFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val fragmentManager = fragmentManager
            if (fragmentManager != null) {
                fragmentManager.beginTransaction()
                        .add(R.id.fragment, TodoFragment())
                        .commit()
            }
        }
    }
}