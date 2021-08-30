package com.example.battaporjects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user.*

class user : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)


        val id=intent.getStringExtra("id")
        val username=intent.getStringExtra("username")

    button8.setOnClickListener {

        val intent = Intent(this, gRall ::class.java)
        intent.putExtra("id",id)
        intent.putExtra("username",username)
        startActivity(intent)
    }
        button9.setOnClickListener {


            val intent = Intent(this, userDipy ::class.java)
            intent.putExtra("id",id)
            intent.putExtra("username",username)
            startActivity(intent)


        }

    }
}
