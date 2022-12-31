package com.kkek.mbts

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Suppress("DEPRECATION")
class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        writeNewPost("my pinno","my fname","my last name","mydep")

    }
    private fun writeNewPost(Pinno: String, FirstName: String, DateOfBirth : String, Department: String) {
        // Create new post at /user-posts/$Pinno/$postid and at
        // /posts/$postid simultaneously
        val database = Firebase.database("https://fir-student-459c5-default-rtdb.firebaseio.com/").getReference("people")
        val post = Post(Pinno,FirstName, DateOfBirth, Department)
        val postValues = post.toMap()
        database.child(pi)
        val childUpdates = hashMapOf<String, Any>(
             "dfgdf" to postValues
        )

        database.updateChildren(childUpdates)
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }

}