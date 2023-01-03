package com.onex.ktapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.onex.ktapp.R
import com.onex.ktapp.base.BaseActivity

class LoginActivity : BaseActivity<LoginViewModel>(R.layout.activity_login) {

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }


    override fun initView(savedInstanceState: Bundle?) {
        var mUsername = findViewById<EditText>(R.id.username)
        var mPassword = findViewById<EditText>(R.id.password)
        var btnLogin = findViewById<Button>(R.id.login)

        btnLogin.setOnClickListener {
            mViewModel.login(mUsername.text.toString(), mPassword.text.toString()) {
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun hideLoading() {
    }
}