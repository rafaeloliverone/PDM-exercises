package com.example.autentica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etLogin = findViewById<EditText>(R.id.etLogin)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btCancel = findViewById<Button>(R.id.btCancel)
        btCancel.setOnClickListener {

            etLogin.setText("")
            etPassword.setText("")

            Toast.makeText(this,  "Cancelled", Toast.LENGTH_SHORT).show()

        }

        val btSignIn = findViewById<Button>(R.id.btSignIn)
        btSignIn.setOnClickListener {

            if ( etLogin.text.toString() == "admin" && etPassword.text.toString() == "1234" ){
                Log.i("APP_AUTH", "Successfully logged in ")
                val intent = Intent(this, LoginSucessActivity::class.java)
                startActivity(intent)

            } else {
                Log.i("APP_AUTH", "Login with errors")
                Toast.makeText(this,  "Login or password wrong", Toast.LENGTH_SHORT).show()
            }

        }



    }
}
