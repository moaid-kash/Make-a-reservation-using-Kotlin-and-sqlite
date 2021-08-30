package com.example.battaporjects

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rhalt.*

class rhalt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rhalt)

        val depa= arrayOf("بحري","امدرمان","الخرطوم")
        val arr = ArrayAdapter(this,android.R.layout.simple_spinner_item,depa)

        spinner.adapter =arr


        val dss= arrayOf("مدني","الابيض","الشماليه","بورتسودان")
        val arrayAdapterr = ArrayAdapter(this,android.R.layout.simple_spinner_item,dss)

        spinner2.adapter =arrayAdapterr



        val departclass= arrayOf("موقف شندي","السوق الشعبي","المنياء البري")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,departclass)

        spinner3.adapter =arrayAdapter



        val pss= arrayOf("2000","3000","4000","5000","6000","7000","8000","9000","10000")
        val arraypter = ArrayAdapter(this,android.R.layout.simple_spinner_item,pss)

        spinner4.adapter =arraypter



        val departcls= arrayOf("4","5","6","7","8","9","10","11","12")
        val arrayAdr = ArrayAdapter(this,android.R.layout.simple_spinner_item,departcls)

        spinner5.adapter =arrayAdr

                        button7.setOnClickListener {

                            addstd()



                        }


    }






    fun addstd() {
        val db = DBMmanager(this)
        val value = ContentValues()

        value.put("Rin", spinner.selectedItem.toString())
        value.put("Rto", spinner2.selectedItem.toString() )
        value.put("Rlon", spinner3.selectedItem.toString())
        value.put("Rpest",spinner4.selectedItem.toString())
        value.put("Rtim", spinner5.selectedItem.toString())
        value.put("Rnus","45")

        val id = db.imsertRhal(value)
        if (id > 0) {
            val intent = Intent(this, admin::class.java)
            startActivity(intent)

            Toast.makeText(this, "تمت اضافة الرحلة بنجاح ", Toast.LENGTH_LONG).show()

        } else {

            val intent = Intent(this, admin::class.java)
            startActivity(intent)

            Toast.makeText(this, "is not  rejester", Toast.LENGTH_LONG).show()

        }


    }
}
