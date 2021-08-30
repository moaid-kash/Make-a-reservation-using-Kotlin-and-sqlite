package com.example.battaporjects

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conent.*
import kotlinx.android.synthetic.main.activity_rhalt.*
import java.util.concurrent.RunnableScheduledFuture

class conent : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conent)

        val Rpass = intent.getStringExtra("Rpass")
        val Rnus = intent.getStringExtra("Rnus")
        val Rin = intent.getStringExtra("Rin")
        val Rto = intent.getStringExtra("Rto")
        val Rtim = intent.getStringExtra("Rtim")
        val Rlon = intent.getStringExtra("Rlon")


        val id = intent.getStringExtra("id")
        val username = intent.getStringExtra("username")

        val tol :Int= Rpass!!.toInt() * Rnus!!.toInt()

        ///Toast.makeText(this," tol "+Rnus.toInt(),Toast.LENGTH_LONG).show()

       // Toast.makeText(this," tol $tol" +Rnus!!.toInt(),Toast.LENGTH_LONG).show()

        textView19.text = Rin
       textView20.text = Rto
        textView21.text = Rtim
        textView22.text = Rlon
        textView23.text = textView23.text.toString() + ": " + tol.toString()
        textView24.text = Rnus





        button12.setOnClickListener {


           val db = DBMmanager(this)
            val value = ContentValues()

            value.put("Rin",Rin )
            value.put("Rto",Rto  )
            value.put("hns", Rnus )
            value.put("hnu",tol  )

            value.put("flaa","no" )
            value.put("hlon",Rlon  )
            value.put("USER", id )
            value.put("Rname",username  )
            value.put("hday","no"  )
            value.put("hnuse","no"  )


            val id = db.imsertNotesH(value)
            if (id > 0) {
                Toast.makeText(this, "is Rejester ", Toast.LENGTH_LONG).show()
                val intent = Intent(this, Main2Activity ::class.java)

                startActivity(intent)


            } else {

                Toast.makeText(this, "is not  rejester", Toast.LENGTH_LONG).show()

            }


        }











    }
}
