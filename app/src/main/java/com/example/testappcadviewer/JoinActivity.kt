package com.example.testappcadviewer

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JoinActivity:AppCompatActivity() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_layout)

        textView=findViewById(R.id.textView8)
        textView.setOnClickListener()
        {
            val a = Intent(this,LoginActivity::class.java)
            startActivity(a)
        }
    }
}