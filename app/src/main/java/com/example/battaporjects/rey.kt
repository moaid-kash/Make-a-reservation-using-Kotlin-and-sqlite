package com.example.battaporjects

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rey.*

class rey : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rey)


        button3.setOnClickListener {
            save()
        }

    }


    private fun save(){

        if (editText3.text .toString() == ""){
            editText3.error="رجاء ادخال الاسم "

        }
        if ( editText4.text.toString() == ""){
            editText4.error="الرجاء ادخال العنوان "

        }
        if ( editText5.text.toString()==""){
            editText5.error="الرجاء ادخال رقم الهاتف"

        }
        if ( editText6.text.toString()==""){
            editText6.error="الرجاء ادخال   كلمة المرور "

        }
        if ( editText7.text.toString()!= editText6.text.toString()){
            editText6.error="الرجاء  التحقق من كلمة المرور "

        }



        if (    (editText3.text .toString() != "") && (editText4.text .toString() != "")
            && ( editText7.text.toString()== editText6.text.toString())
            &&(editText5.text .toString() != "") &&(editText6.text .toString() != "")   ) {

            addstd()
        }
    }







    fun addstd() {
        val db = DBMmanager(this)
        val value = ContentValues()

        value.put("userName", editText3.text .toString())
        value.put("useradderrs", editText4.text.toString() )
        value.put("usersphon", editText5.text .toString() )
        value.put("uaserpass", editText6.text .toString())
        val id = db.imsertNotes(value)
        if (id > 0) {
            Toast.makeText(this, "is Rejester ", Toast.LENGTH_LONG).show()
            val intent = Intent(this, besa ::class.java)

            startActivity(intent)


        } else {

            Toast.makeText(this, "is not  rejester", Toast.LENGTH_LONG).show()

        }


    }

}
