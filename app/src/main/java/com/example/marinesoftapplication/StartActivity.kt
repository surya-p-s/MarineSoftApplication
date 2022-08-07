package com.example.marinesoftapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val signIn=findViewById<Button>(R.id.signinButton)
        val register=findViewById<Button>(R.id.registerButton)

        signIn.setOnClickListener {
            val intent = Intent(this, SignInPage::class.java)
            startActivity(intent)
            finish()
        }
        register.setOnClickListener {
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
            finish()
        }
    }
}