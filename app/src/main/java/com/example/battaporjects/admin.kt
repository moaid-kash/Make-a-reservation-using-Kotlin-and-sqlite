package com.example.battaporjects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin.*

class admin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        button4.setOnClickListener {
            val intent = Intent(this, rhalt::class.java)
            startActivity(intent)
        }

        button5.setOnClickListener {
            val intent = Intent(this, updateRal::class.java)
            startActivity(intent)


        }

        button6.setOnClickListener {
            val intent = Intent(this, updateHgz::class.java)
            startActivity(intent)



        }
    }





}
