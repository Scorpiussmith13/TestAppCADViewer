package com.example.testappcadviewer

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class JoinActivity:AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button2:Button
    lateinit var registerEmail:EditText
    lateinit var registerPassword:EditText
    lateinit var studentRegister:RadioButton
    lateinit var recruiterRegister:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_layout)

        textView=findViewById(R.id.textView8)
        button2=findViewById(R.id.button2)
        registerEmail=findViewById(R.id.registerEmail)
        registerPassword=findViewById(R.id.registerPassword)
        studentRegister=findViewById(R.id.studentRegister)
        recruiterRegister=findViewById(R.id.recruiterRegister)

        textView.setOnClickListener()
        {
            val a = Intent(this,LoginActivity::class.java)
            startActivity(a)
        }
        button2.setOnClickListener()
        {
            when
            {
                TextUtils.isEmpty(registerEmail.text.toString().trim{it<= ' '})->{//trim is used to trim the
                    // empty spaces from the beginning to the end
                    Toast.makeText(this,"Please enter the email Id!",Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(registerPassword.text.toString().trim{it <= ' '})->{
                    Toast.makeText(this,"Please enter the password!",Toast.LENGTH_SHORT).show()
                }
                !studentRegister.isChecked && !recruiterRegister.isChecked ->
                {
                    Toast.makeText(this,"please select whether you are recruiter or a student",Toast.LENGTH_SHORT).show()
                }
                /*!recruiterRegister.isChecked->
                {
                    Toast.makeText(this,"Please select whether you are recruiter or a student0",Toast.LENGTH_SHORT).show()
                }*/
                else -> {
                    val email: String = registerEmail.text.toString().trim { it <= ' ' }
                    val password: String = registerPassword.text.toString().trim { it <= ' ' }

                    if(studentRegister.isChecked)
                    {
                        val s:String=studentRegister.getText().toString()
                        //Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
                    }
                    else {
                        val s: String = recruiterRegister.getText().toString()
                        //Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
                    }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                        // If the registration is successfully done
                        if (task.isSuccessful) {
                            //Firebase registered user
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            Toast.makeText(
                                this,
                                "You are registered successfully.",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK//to get rid of extra
                            //instances of activities
                            startActivity(intent)
                            finish()
                        }
                        else
                        {
                            // if the registering is not successful then show error message.
                            Toast.makeText(this,task.exception!!.message.toString(),Toast.LENGTH_SHORT).show()


                        }
                    }

                }

            }
        }
    }
}