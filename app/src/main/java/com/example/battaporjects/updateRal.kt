package com.example.battaporjects

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
 import kotlinx.android.synthetic.main.activity_update_ral.*
import kotlinx.android.synthetic.main.pass.view.*

class updateRal : AppCompatActivity() {


    var RlID:String=""
    var Rin:String=""
    var Rto:String=""
    var Rlon:String=""
    var Rpas:String = ""
    var Rnus:String=""
    var Rtim:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_ral)

        query("%")
    }



    inner class MyNotesAdpater: BaseAdapter {
        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val myView=layoutInflater .inflate(R.layout .pass ,null)
            val note=listN [p0]


          myView .textView44.text  =note .Rnus
           myView .textView47 .text  =note .Rpass


             myView .textView51.text  =note .Rin
           myView .textView52.text  =note .Rlon
             myView .textView53.text  =note .Rto
            myView .textView52.text  =note .Rtim
            myView .textView55.text  =note .Rlon

            myView . button17.setOnClickListener {
               /// تعديل
                val intt=Intent(this@updateRal,updateRalEnd::class.java)

                intt.putExtra("id",note.RlID)
                startActivity(intt)


            }

                myView .button16.setOnClickListener {


                val dbMmanager = DBMmanager(this@updateRal)
                val sele= arrayOf(note .RlID)
                dbMmanager.deleteR("ID=?",sele)
                Toast.makeText(this.content!!,"Delete ", Toast .LENGTH_LONG).show()

                    query("%")

                // حذف


            }





            return myView


        }

        override fun getItem(p0: Int): Any {
            return listN [p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listN .size

        }

        var listN=ArrayList<RhaltClass>()
        var content: Context?=null
        constructor(content: Context, listN:ArrayList<RhaltClass>):super()
        {
            this.content=content
            this.listN=listN


        }



    }


    var listNotes=ArrayList<RhaltClass>()


    fun query(tilt:String){
        var dbMmanager= DBMmanager( this)
        val p = arrayOf("Rin","Rto","Rlon","Rpest","Rnus","ID","Rtim")
        val selec= arrayOf(tilt)
        var cursor=dbMmanager.queryR(p,"ID like ?" ,selec,"ID")
        if (cursor.moveToFirst()){
            do {
                RlID =cursor.getString(cursor.getColumnIndex("ID"))
                Rin =cursor.getString (cursor.getColumnIndex("Rin"))
                Rto  =cursor.getString(cursor.getColumnIndex("Rto"))
                Rlon =cursor.getString(cursor.getColumnIndex("Rlon"))
                Rpas =cursor.getString (cursor.getColumnIndex("Rpest"))
                Rnus  =cursor.getString(cursor.getColumnIndex("Rnus"))
                Rtim  =cursor.getString(cursor.getColumnIndex("Rtim"))

                listNotes.add(RhaltClass(RlID,Rin ,Rto,Rlon,Rpas,Rnus,Rtim))
            }while (cursor.moveToNext())

        }
        val myAdapter=MyNotesAdpater(this, listNotes)
        last.adapter=myAdapter

    }


}
