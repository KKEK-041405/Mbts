package com.kkek.mbts

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        findViewById<Button>(R.id.loginbtn).setOnClickListener {
         val username = findViewById<EditText>(R.id.username).text.toString()
         val password = findViewById<EditText>(R.id.password).text.toString()   
            if(validateform(username,password)){
                getdetails(username,password)
            }
        }
        findViewById<Button>(R.id.Reginsterbtn).setOnClickListener {
            registerpage()
        }
    }

    private fun registerpage() {
        val intent = Intent(applicationContext,CreatePassword::class.java)
        startActivity(intent)
    }

    private fun getdetails(username: String, password: String) {
        Toast.makeText(this, username+password, Toast.LENGTH_SHORT).show()
        val db = Firebase.database("https://fir-student-459c5-default-rtdb.firebaseio.com/")
        val myref = db.getReference("people")
        myref.child(username).get().addOnSuccessListener {
            Toast.makeText(this, "${it.value}", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,Dashboard::class.java)
            intent.putExtra("pinno",username)
            startActivity(intent)
        }
    }

    private fun validateform(username: String, password: String): Boolean {
        if (username != "" && password != ""){
            return true
        }
        else{
            Toast.makeText(this, "username or password can't be empty", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}