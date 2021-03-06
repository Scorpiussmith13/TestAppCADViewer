package com.example.testappcadviewer

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity: AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var signInEmailId: EditText
    lateinit var signInPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        textView = findViewById(R.id.joinpage)
        button = findViewById(R.id.SignIn)
        signInEmailId = findViewById(R.id.signInEmailId)
        signInPassword = findViewById(R.id.signInPassword)

        textView.setOnClickListener()
        {
            val a = Intent(this, JoinActivity::class.java)
            startActivity(a)
        }
        button.setOnClickListener()
        {
            when {
                TextUtils.isEmpty(signInEmailId.text.toString().trim { it <= ' ' }) -> {

                    Toast.makeText(this, "Please enter the email Id!", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(signInPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter the password!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val email: String = signInEmailId.text.toString().trim { it <= ' ' }
                    val password: String = signInPassword.text.toString().trim { it <= ' ' }

                    //login using FirebaseAuth
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                //After successful login

                                Toast.makeText(
                                    this,
                                    "You are logged in successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK//to get rid of extra
                                //instances of activities
                                startActivity(intent)
                                finish()
                            } else {
                                // if the sign in is not successful then show error message.
                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()


                            }

                        }

                }

            }
        }
    }
}