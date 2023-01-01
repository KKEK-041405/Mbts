package com.kkek.mbts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CreatePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password)
        val database = Firebase.database("https://fir-student-459c5-default-rtdb.firebaseio.com/").getReference("people")

        findViewById<Button>(R.id.Continue).setOnClickListener {
            checkpassword(database)
        }
    }

    private fun checkpassword(database: DatabaseReference) {
        val pinno = findViewById<EditText>(R.id.editTextTextPersonName5).text.toString()
        val password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
        val confrim  = findViewById<EditText>(R.id.editTextTextPassword2).text.toString()
        database.child(pinno).get().addOnSuccessListener {
            Toast.makeText(this,"user already exists, pls login",Toast.LENGTH_SHORT)
        }.addOnFailureListener {
            if (pinno != "" && password == confrim){
                val intent = Intent(applicationContext,Register::class.java)
                intent.putExtra("Pinno",pinno)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"pls check username and password",Toast.LENGTH_SHORT)
            }
        }

    }
}