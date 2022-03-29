package com.example.testappcadviewer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        textView=findViewById(R.id.joinpage)
        button=findViewById(R.id.button)

        textView.setOnClickListener()
        {
            val a = Intent(this,JoinActivity::class.java)
            startActivity(a)
        }
        button.setOnClickListener()
        {
            val a=Intent(this,MainActivity::class.java)
            startActivity(a)
        }
    }
}