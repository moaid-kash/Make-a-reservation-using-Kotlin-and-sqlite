package com.example.battaporjects

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_hgz.*
import kotlinx.android.synthetic.main.up_hgz.view.*

class updateHgz : AppCompatActivity() {

    var idR=""
    var iduser=""
    var username=""
var nu=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_hgz)

        queryTitle("%")

    }







    inner class MyNotesAdpater: BaseAdapter {
        @SuppressLint("ViewHolder", "InflateParams", "SetTextI18n")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val myView=layoutInflater .inflate(R.layout .up_hgz ,null)
            val note=listN [p0]
            var msg=""
                if (note.flaa.equals("no"))
                    {
                    msg=  " لم يتم تاكيد الحجز "

                        myView.textView36.setTextColor(Color.RED)

                    }else
                    {

                        msg=  "   يتم تاكيد الحجز "

                        myView.textView36.setTextColor(Color.BLUE)


                    }


            iduser=note.IDUSER
            username=note.hname
            idR=note.hID
            myView .textView34.text  =" من "+note .hin
            myView .textView35 .text  ="الي "+note .hto


            myView .textView37.text  =" صاحب الطلب "+note .hname
            myView .textView38.text  =""
            myView .textView36.text  =msg
            myView .textView40.text  =" عدد المقاعد "+note .hns
            myView .textView39.text  =" السعر الكلي"+note .hnu


            myView . button15.setOnClickListener {
                /// تعديل
             if (note.flaa.equals("no")){
                         upDate()
                        val ph= queryTitleUserPhon("%")!!

                    Toast.makeText(this@updateHgz, "this $ph",Toast.LENGTH_LONG).show()

                 val  ou=Uri.parse("tel:$ph")

                    val intent=Intent(Intent.ACTION_DIAL,ou)
                    startActivity(intent)

                }else{

                 Toast.makeText(this@updateHgz, " تم تاكيد الحجز سابقاً ",Toast.LENGTH_LONG).show()

             }





            }

            myView .button18.setOnClickListener {


                // حذف
                    val dbMmanager = DBMmanager(this@updateHgz)
                    val sele= arrayOf(note .hID .toString())
                    dbMmanager.deleteH("ID=?",sele)
                    Toast.makeText(this.content!!,"تم حذف الطلب.. !!!", Toast .LENGTH_LONG).show()

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





    var listNotes=ArrayList<Hgal>()




    fun queryTitle(tilt:String){



        var hID=""//
        var hin=""//من
        var hto=""//الي
        var Rname=""//اسم الجاحز (طبعا دي ح يجي من الجدول المسخدمين)
        var IDUSER=""
        var hns=""// عدد المقاعد
        var hnu=""//السعر
        var flaa=""//// تاكيد الحجز





var u=""



        var dbMmanager= DBMmanager( this)
        val p = arrayOf("Rin","Rto","hns","Rname","USER","hnu","ID","flaa")
        val selec= arrayOf(tilt)
        var cursor=dbMmanager.queryh(p,"ID like ?" ,selec,"ID")
        if (cursor.moveToFirst()){
            do {
                hID =cursor.getString(cursor.getColumnIndex("ID"))
                hin =cursor.getString (cursor.getColumnIndex("Rin"))
                hto  =cursor.getString(cursor.getColumnIndex("Rto"))
                hns =cursor.getString(cursor.getColumnIndex("hns"))
                Rname =cursor.getString (cursor.getColumnIndex("Rname"))
                IDUSER  =cursor.getString(cursor.getColumnIndex("USER"))
                hnu  =cursor.getString(cursor.getColumnIndex("hnu"))
                flaa  =cursor.getString(cursor.getColumnIndex("flaa"))


                    listNotes.add(Hgal(hID, hin, hto, Rname, IDUSER, hns, hnu, "", "", flaa, ""))

                            }while (cursor.moveToNext())

        }
        val myAdapter=MyNotesAdpater(this, listNotes)
        updateList.adapter=myAdapter

    }




    fun upDate() {
        val db = DBMmanager(this)
        val value = ContentValues()
        value.put("hday","الاربعاء  24/3" )
        value.put("flaa","yes"  )





        val arg= arrayOf(idR)
        val id = db.upDateHgaz(value,"ID=?",arg)
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




    fun queryTitleUserPhon(tilt: String) : String? {
        var dbMmanager = DBMmanager(this)
        val p = arrayOf("userName", "useradderrs","ID")
        val selec = arrayOf(tilt)
        var cursor = dbMmanager.queryuser (p, " userName like ?", selec, "userName")
        if (cursor.moveToFirst()) {

            do {
                val spass = cursor.getString(cursor.getColumnIndex("useradderrs"))

                val u =cursor.getString(cursor.getColumnIndex("userName"))
                 val i=cursor.getString(cursor.getColumnIndex("ID"))

                if (u.equals(username)&& i==iduser) {
                    return spass

                }
            } while (cursor.moveToNext())


        }

        return null
    }



}
