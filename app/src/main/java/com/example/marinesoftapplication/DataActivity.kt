package com.example.marinesoftapplication

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DataActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
//    private lateinit var drawblelayout:DrawerLayout
//    private lateinit var navigationview:NavigationView
//    private lateinit var toolbar:Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        // Authentiation
        auth = Firebase.auth
        val logOut=findViewById<Button>(R.id.logOut)
        logOut.setOnClickListener{
            Firebase.auth.signOut()
            updateUI()
        }
        val uploadButton=findViewById<FloatingActionButton>(R.id.addpicButton)

        uploadButton.setOnClickListener {
            val intent=Intent(this,UploadActivity::class.java)
            startActivity(intent)
        }

        // Menu Layout
//        drawblelayout=findViewById(R.id.drawablelayout)
//        navigationview=findViewById(R.id.navigationView)
//        toolbar=findViewById(R.id.toolBar)


    }



    private fun updateUI() {
        val intent= Intent(this,SignInPage::class.java)
        startActivity(intent)
        finish()
    }
}