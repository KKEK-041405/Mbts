package com.kkek.mbts

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Suppress("DEPRECATION")
class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        findViewById<Button>(R.id.Registerbtn3).setOnClickListener { getdetails() }

    }

    private fun getdetails() {
        val Pinno = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
        val FirstName   = findViewById<EditText>(R.id.editTextTextPersonName2).text.toString()
        val LastName = findViewById<EditText>(R.id.editTextTextPersonName3).text.toString()
        val Dipartment = findViewById<EditText>(R.id.editTextTextPersonName4).text.toString()
        val DateOfBirth = findViewById<EditText>(R.id.Dateofbrith).text.toString()
        if(Pinno != ""){
            if (FirstName != ""){
                if (LastName != ""){
                    if (Dipartment != ""){
                        if (DateOfBirth != ""){
                            writeNewPost(Pinno,FirstName,LastName,DateOfBirth, Dipartment)
                        }else{
                            Toast.makeText(this,"fields can't be empty",Toast.LENGTH_SHORT)
                        }
                    }else{
                        Toast.makeText(this,"fields can't be empty",Toast.LENGTH_SHORT)
                    }
                }else{
                    Toast.makeText(this,"fields can't be empty",Toast.LENGTH_SHORT)
                }
            }else{
                Toast.makeText(this,"fields can't be empty",Toast.LENGTH_SHORT)
            }
        }else{
            Toast.makeText(this,"fields can't be empty",Toast.LENGTH_SHORT)
        }


    }

    private fun writeNewPost(Pinno: String, FirstName: String,Lastname: String, DateOfBirth : String, Department: String) {
        // Create new post at /user-posts/$Pinno/$postid and at
        // /posts/$postid simultaneously
        val database = Firebase.database("https://fir-student-459c5-default-rtdb.firebaseio.com/").getReference("people")
        val post = Post(FirstName,Lastname,DateOfBirth,Department)
        val postValues = post.toMap()
        database.child(Pinno)
        val childUpdates = hashMapOf<String, Any>(
             Pinno to postValues
        )

        database.updateChildren(childUpdates)
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }

}