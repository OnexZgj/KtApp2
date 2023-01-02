package com.onex.ktapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.onex.ktapp.ui.LoginViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.tv_info)


        val loginViewMode = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginViewMode.login("","") {

            Toast.makeText(this, "login success!", Toast.LENGTH_SHORT).show()
        }
    }
}