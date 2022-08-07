package com.example.marinesoftapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DataActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        auth = Firebase.auth
        val logOut=findViewById<Button>(R.id.logOut)

        logOut.setOnClickListener{
            val progressBar=findViewById<ProgressBar>(R.id.progressBar3)
            progressBar.visibility= View.VISIBLE
            Firebase.auth.signOut()
            updateUI()
        }
    }

    private fun updateUI() {
        val progressBar=findViewById<ProgressBar>(R.id.progressBar3)
        progressBar.visibility= View.VISIBLE
        val intent= Intent(this,LogInPage::class.java)
        startActivity(intent)
        finish()
    }
}