package com.example.testappcadviewer

class users {

     private lateinit var Email:String
     private lateinit var Password:String

     fun users()
     {

     }

     constructor(Email: String, Password: String) {
          this.Email = Email
          this.Password = Password
     }

     fun get_Email():String
{
     return Email
}
     fun set_Email(email:String) {
          Email=email
     }
     fun get_Password():String
     {
          return Password
     }
     fun set_Password(password:String) {
          Password=password
     }
}