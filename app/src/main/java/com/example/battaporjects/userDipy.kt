package com.example.battaporjects

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_dipy.*
import kotlinx.android.synthetic.main.disuser.view.*

class userDipy : AppCompatActivity() {

    var iduser=""
    var username=""
    var listNotes=ArrayList<Hgal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dipy)


          this.iduser =intent.getStringExtra("id")!!
          username=intent.getStringExtra("username")!!

         queryTitle("%")
    }



    inner class MyNotesAdpater: BaseAdapter {
        @SuppressLint("ViewHolder", "InflateParams", "SetTextI18n")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val myView=layoutInflater .inflate(R.layout .disuser  ,null)
            val note=listN [p0]


            if (note.flaa.equals("no")){

                myView.textView30.text= " لم يتم تاكيد الحجز"

                myView.textView30.setTextColor(Color.RED)

            }else{
                val un=note.hID
                myView.textView30.text= "   تم تاكيد الحجز  رقم الحجز هو $un"
                myView.textView30.setTextColor(Color.GREEN)


            }


            myView.textView26.text=note.hin

            myView.textView27.text=note.hto

            myView.textView28.text=note.hname
            myView.textView29.text=note.hns

            myView.textView31.text=note.hday// تاريخ الحجز


            myView.button14.setOnClickListener {

                val dbMmanager = DBMmanager(this@userDipy)
                val sele= arrayOf(note .hID .toString())
                dbMmanager.deleteH("ID=?",sele)
                Toast.makeText(this.content!!,"Delete of Notse ${note.hname.toString()}", Toast .LENGTH_LONG).show()

                queryTitle("%")

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

        var listN=ArrayList<Hgal>()
        var content: Context?=null
        constructor(content: Context, listN:ArrayList<Hgal>):super()
        {
            this.content=content
            this.listN=listN


        }



    }





    fun queryTitle(tilt:String){
        var dbMmanager=DBMmanager( this)
        val p = arrayOf("ID","Rin","Rto","hnu","USER","hns","hday","hnuse","flaa","hlon")
        val selec= arrayOf(tilt)
        var cursor=dbMmanager.queryh(p,"ID like ?" ,selec,"ID")
        if (cursor.moveToFirst()){
            do {

                val hID =cursor.getString(cursor.getColumnIndex("ID"))

                val hin =cursor.getString (cursor.getColumnIndex("Rin"))
                val hto  =cursor.getString(cursor.getColumnIndex("Rto"))
                val Rlon =cursor.getString(cursor.getColumnIndex("hnu"))

                val IDUSER: String=cursor.getString(cursor.getColumnIndex("USER"))
                val hns: String=cursor.getString(cursor.getColumnIndex("hns"))
                val hnu: String=cursor.getString(cursor.getColumnIndex("hnu"))

                val hday: String=cursor.getString(cursor.getColumnIndex("hday"))
                val hnuse: String=cursor.getString(cursor.getColumnIndex("hnuse"))
                val flaa: String=cursor.getString(cursor.getColumnIndex("flaa"))
                val hlon: String=cursor.getString(cursor.getColumnIndex("hlon"))

                    if (IDUSER==iduser){

                        listNotes.add(Hgal(hID ,hin ,hto,Rlon,IDUSER,hns,hnu,hday,hnuse,flaa,hlon))
                        }
                }while (cursor.moveToNext())

        }
        var myAdapter=MyNotesAdpater(this, listNotes)
        listviwe.adapter=myAdapter

    }


}
