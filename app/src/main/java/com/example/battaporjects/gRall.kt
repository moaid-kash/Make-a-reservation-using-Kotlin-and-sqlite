package com.example.battaporjects

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_g_rall.*
import kotlinx.android.synthetic.main.activity_rhalt.view.*
import kotlinx.android.synthetic.main.gg.view.*

class gRall : AppCompatActivity() {


    var RlID:String=""//
    var Rin:String=""//من
    var Rto:String=""//الي
    var Rlon:String=""//الموقع بعد الرحله (السوق الشعبي)
    var Rpas:String = "" //السعر
    var Rnus:String=""//عدد المقاعد
    var Rtim:String=""// مده الرحله
    var id:String=""
    var  username=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_g_rall)


         id= intent.getStringExtra("id")!!
        username= intent.getStringExtra("username")!!

        val departcls= arrayOf("1","2","3","4","5","6","7","8","9","10")
        val arrayAdr = ArrayAdapter(this,android.R.layout.simple_spinner_item,departcls)

        spinner6.adapter =arrayAdr


        queryTitle("%")

    }


    var listNotes=ArrayList<RhaltClass>()



    inner class MyNotesAdpater: BaseAdapter {
        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val myView=layoutInflater .inflate(R.layout .gg  ,null)
            val note=listN [p0]
            myView .textView7.text  =note .Rnus
            myView .textView9 .text  =note .Rpass
            myView .textView11.text  =note .Rin
            myView .textView17.text  =note .Rlon
            myView .textView15.text  =note .Rto
            myView .textView13.text  =note .Rtim

            myView.button10.setOnClickListener {
                val intent = Intent(this@gRall, conent::class.java)

                intent.putExtra("Rnus",spinner6.selectedItem.toString())
                intent.putExtra("Rpass",note .Rpass)
                intent.putExtra("Rin",note .Rin)
                intent.putExtra("Rlon",note .Rlon)
                intent.putExtra("Rto",note .Rto)
                intent.putExtra("Rtim",note .Rtim)

                intent.putExtra("id",id)
                intent.putExtra("username",username)

                startActivity(intent)



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


    /////////////////////////////////////////////////




    //////////////////////////////////









    fun queryTitle(tilt:String){
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
        var myAdapter=MyNotesAdpater(this, listNotes)
        lis.adapter=myAdapter

    }


}
