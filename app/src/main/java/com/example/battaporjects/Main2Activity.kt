package com.example.battaporjects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_conent.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView25.text="تم استلام  طلب الحجز سوف توصل مننا مكالمه لتاكيد الحجز و تحدد موعد الرحلة "

        button13.setOnClickListener {

            val intent = Intent(this,user::class.java)

            startActivity(intent)

        }

    }
}
