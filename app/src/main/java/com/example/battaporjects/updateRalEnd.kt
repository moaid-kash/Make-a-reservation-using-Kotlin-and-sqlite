package com.example.battaporjects

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_ral_end.*

class updateRalEnd : AppCompatActivity() {

    var idR:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_ral_end)


            idR= intent.getStringExtra("id") !!

        val depa= arrayOf("مدني","بحري","امدرمان","الخرطوم")
        val arr = ArrayAdapter(this,android.R.layout.simple_spinner_item,depa)

        spinner7.adapter =arr


        val dss= arrayOf("الابيض","الشماليه","بورتسودان")
        val arrayAdapterr = ArrayAdapter(this,android.R.layout.simple_spinner_item,dss)

        spinner8.adapter =arrayAdapterr



        val departclass= arrayOf("موقف شندي","السوق الشعبي","المنياء البري")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,departclass)

        spinner10.adapter =arrayAdapter



        val pss= arrayOf("2000","3000","4000","5000","6000","7000","8000","9000","10000")
        val arraypter = ArrayAdapter(this,android.R.layout.simple_spinner_item,pss)

        spinner11.adapter =arraypter



        val departcls= arrayOf("4","5","6","7","8","9","10","11","12")
        val arrayAdr = ArrayAdapter(this,android.R.layout.simple_spinner_item,departcls)

        spinner12.adapter =arrayAdr


        button20.setOnClickListener {

            upDate()

        }

    }


    fun upDate() {
        val db = DBMmanager(this)
        val value = ContentValues()

        value.put("Rin", spinner7.selectedItem.toString())
        value.put("Rto", spinner8.selectedItem.toString() )
        value.put("Rlon", spinner10.selectedItem.toString())
        value.put("Rpest",spinner11.selectedItem.toString())
        value.put("Rtim", spinner12.selectedItem.toString())




        val arg= arrayOf(idR)
        val id = db.upDateRhal(value,"ID=?",arg)
        if (id > 0) {
            val intent = Intent(this, admin::class.java)
            startActivity(intent)

            Toast.makeText(this, "This UpDate", Toast.LENGTH_LONG).show()

        } else {

            val intent = Intent(this, admin::class.java)
            startActivity(intent)

            Toast.makeText(this, " not This UpDate", Toast.LENGTH_LONG).show()

        }


    }

}
