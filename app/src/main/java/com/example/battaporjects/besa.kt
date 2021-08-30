package com.example.battaporjects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_besa.*

class besa : AppCompatActivity() {

    var username=""
    var IDUSER=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_besa)


        button.setOnClickListener {
            login()
        }

        button2.setOnClickListener {
            val intent = Intent(this, rey ::class.java)
            startActivity(intent)


        }

    }



    private fun login() {
        val name = editText.text.toString()
        val password = editText2.text.toString()
        if ((name.equals("batta@admin")) && (password.equals("123456"))) {
            val intent = Intent(this, admin ::class.java)
            startActivity(intent)

        }else

            if( queryuser(name,password)==2){

                val intent = Intent(this, user ::class.java)
                intent.putExtra("id",IDUSER)
                intent.putExtra("username",username)
                startActivity(intent)

            }else

                if( queryuser(name,password)==1) {

                    editText2.error = "check password"
                }
                else

                    if( queryuser(name,password)==0) {


                        editText.error = "check user name"
                        editText2.error = "check password"
                    }


    }

    fun queryuser(user: String,pass:String) :Int {
        var dbMmanager = DBMmanager(this)
        val p = arrayOf("userName", "uaserpass","ID")
        val selec = arrayOf(user)
        var cursor = dbMmanager.queryuser (p, " userName like ?", selec, "userName")
        if (cursor.moveToFirst()) {

            do {
                val spass = cursor.getString(cursor.getColumnIndex("uaserpass"))

                    username=cursor.getString(cursor.getColumnIndex("userName"))
                    IDUSER=cursor.getString(cursor.getColumnIndex("ID"))

                if (pass == spass) {
                    return 2
                }
            } while (cursor.moveToNext())
            return 1

        }

        return 0
    }

}
