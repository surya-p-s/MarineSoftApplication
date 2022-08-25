package com.example.marinesoftapplication

import android.content.ClipData
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DataActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        auth = Firebase.auth

        val home=findViewById<NavigationBarItemView>(R.id.home_menu)
         home.setOnClickListener {
             startActivity(Intent(this,DataActivity::class.java))
         }

        val signOut=findViewById<NavigationBarItemView>(R.id.signOut)
        // Authentiation
        signOut.setOnClickListener{
            Firebase.auth.signOut()
            updateUI()
        }
        val uploadButton=findViewById<NavigationBarItemView>(R.id.imageUpload)
//
        uploadButton.setOnClickListener {
            val intent=Intent(this,UploadActivity::class.java)
            startActivity(intent)
        }

    }



    private fun updateUI() {
        val intent= Intent(this,SignInPage::class.java)
        startActivity(intent)
        finish()
    }
}