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

//        val login = RetrofitHelper.service.login("123","465")
//        login.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<HttpResult<LoginData>> {
//                override fun onNext(t: HttpResult<LoginData>) {
////                    Log.d("xxx", t.data?.toString())
////                    textView.text = t.data?.toString()
//                }
//
//                override fun onSubscribe(d: Disposable) {
//
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.e("xxx", e.message.toString())
//                }
//
//                override fun onComplete() {
//                }
//
//            })

//        var loginIntent = Intent(this, LoginActivity::class.java)
//
        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {

            loginViewMode.login("Onexzgj","13102119zgj") {
                Log.d("fuck","success ok 的了")
                Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show()

            }
        }
    }
}