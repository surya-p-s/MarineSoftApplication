package com.example.marinesoftapplication

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var registerButton : Button

    private lateinit var sEmail : String
    private lateinit var sPassword : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        val progressBar=findViewById<ProgressBar>(R.id.progressBar2)
        registerButton = findViewById(R.id.registerButton)
        email = findViewById(R.id.emailText2)
        password = findViewById(R.id.textPassword2)


        registerButton.setOnClickListener {

            sEmail = email.text.toString().trim()
            sPassword = password.text.toString().trim()
            progressBar.visibility= View.VISIBLE

            auth.createUserWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(ContentValues.TAG, "signInWithEmail:success")
                        val user = auth.currentUser

                        updateUI(user)
                    } else {
                        Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Already Register.", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this, LogInPage::class.java)
                        progressBar.visibility= View.VISIBLE
                        startActivity(intent)
                        finish()
                    }
                }
        }

        val logIN = findViewById<Button>(R.id.logInButton)

        logIN.setOnClickListener {
            val intent = Intent(this,LogInPage::class.java)
            progressBar.visibility= View.VISIBLE
            startActivity(intent)
        }
    }
    private fun updateUI(user: FirebaseUser?) {

        val progressBar=findViewById<ProgressBar>(R.id.progressBar2)
        progressBar.visibility= View.VISIBLE
        if(user != null) {
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}