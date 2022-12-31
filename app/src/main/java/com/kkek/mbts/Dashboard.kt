package com.kkek.mbts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val intent = intent
        val str = intent.getStringExtra("pinno")
        findViewById<TextView>(R.id.pinnoview).text = str
        showdetails(str)
    }

    private fun showdetails(str: String?) {
        val db = Firebase.database("https://fir-student-459c5-default-rtdb.firebaseio.com/")
        val myref = db.getReference("people")
        myref.child(str.toString()).get().addOnSuccessListener {
            val post = it.getValue<Post>()
            findViewById<TextView>(R.id.pinnoview2).text = post?.FirstName.toString()
            findViewById<TextView>(R.id.pinnoview3).text = post?.LastName.toString()
            findViewById<TextView>(R.id.pinnoview4).text = post?.DateOfBirth.toString()
        }

    }
}