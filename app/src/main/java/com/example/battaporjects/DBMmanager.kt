package com.example.battaporjects

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast

class DBMmanager {
    val dbNmar="Batta"
    val dbNotesTable ="Users"
    val ulID="ID"
    val uname="userName"
    val uadd="useradderrs"
    val uphon="usersphon"
    val upass="uaserpass"

    val dbTableRhal ="rhl"// جدول الرحلات
    val RlID="ID"//
    val Rin="Rin"//من
    val Rto="Rto"//الي
    val Rlon="Rlon"//الموقع بعد الرحله (السوق الشعبي)
    val Rpass="Rpest"//السعر
    val Rnus="Rnus"//عدد المقاعد
    val Rtim="Rtim"// مده الرحله

    val dbTablhaltz ="hgaz"// جدول الحجوزات
    val hID="ID"//
    val hin="Rin"//من
    val hto="Rto"//الي
    val hname="Rname"//اسم الحاجز (طبعا دي ح يجي من الجدول المسخدمين)
    val IDUSER="USER"
    val hns="hns"// عدد المقاعد
    val hnu="hnu"//السعر

    val hday="hday"//التاريخ
    val hnuse="hnuse"/// رقم المقاعد

    val flaa="flaa"//// تاكيد الحجز
    val hlon="hlon"///لالا

    val dbV=1


    val sqlCeateUser="CREATE TABLE IF NOT EXISTS $dbNotesTable ($ulID INTEGER PRIMARY KEY  ,$uname TEXT,$uadd TEXT,$uphon TEXT,$upass TEXT);"

    val sqlCeateR="CREATE TABLE IF NOT EXISTS $dbTableRhal ($RlID INTEGER PRIMARY KEY ,$Rin TEXT ,$Rto TEXT,$Rlon TEXT,$Rpass TEXT,$Rnus TEXT,$Rtim TEXT);"


    val sqlCeateH="CREATE TABLE IF NOT EXISTS $dbTablhaltz ($hID INTEGER PRIMARY KEY  ,$hlon TEXT,$hto TEXT,$flaa TEXT,$hin TEXT,$IDUSER TEXT,$hname TEXT,$hnu TEXT,$hns TEXT,$hday TEXT,$hnuse TEXT);"

    var sqlBD: SQLiteDatabase?=null
    constructor(context: Context)
    {


        var db=DatabsseNotes(context)
        sqlBD =db .writableDatabase

    }



    inner class DatabsseNotes:SQLiteOpenHelper{
        override fun onCreate(p0: SQLiteDatabase?) {
            Toast .makeText(context,"Database is created  ",Toast .LENGTH_LONG).show()

            p0!!.execSQL(sqlCeateUser)

            p0.execSQL(sqlCeateH )
            p0.execSQL(sqlCeateR)

            Toast .makeText(context,"Database is created  ",Toast .LENGTH_LONG).show()

        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("DROP TABLE IF EXISTS $dbNotesTable")

          }


        var context:Context?=null
        constructor(context:Context):super (context,dbNmar,null ,dbV ){

            this.context=context

        }





    }


    fun imsertNotes(valuer:ContentValues):Long{
        val id=sqlBD !!.insert (dbNotesTable ,null,valuer)

        return id


    }



    fun imsertRhal(valuer:ContentValues):Long{
        val id=sqlBD !!.insert (dbTableRhal ,null,valuer)

        return id


    }
    fun imsertNotesH(valuer:ContentValues):Long{
        val id=sqlBD !!.insert (dbTablhaltz ,null,valuer)

        return id


    }



    fun queryuser(P:Array<String>,selec:String,seArgs:Array<String>,sort:String ):Cursor{

        val db =SQLiteQueryBuilder()
        db.tables=dbNotesTable
        val cursor=db.query(sqlBD,P,selec ,seArgs,null,null,sort)
        return cursor

    }
    fun queryh(P:Array<String>,selec:String,seArgs:Array<String>,sort:String ):Cursor{

        val db =SQLiteQueryBuilder()
        db.tables=dbTablhaltz
        val cursor=db.query(sqlBD,P,selec ,seArgs,null,null,sort)
        return cursor

    }
    fun queryR(P:Array<String>,selec:String,seArgs:Array<String>,sort:String ):Cursor{

      val db =SQLiteQueryBuilder()
        db.tables=dbTableRhal
        val cursor=db.query(sqlBD,P,selec ,seArgs,null,null,sort)
      return cursor

    }




    fun deleteH(selec: String,seArgs: Array<String>):Int{
        val cont =sqlBD!!.delete(dbTablhaltz,selec,seArgs)
        return cont



    }

    fun deleteR(selec: String,seArgs: Array<String>):Int{
        val cont =sqlBD!!.delete(dbTableRhal,selec,seArgs)
        return cont


    }


    fun upDateRhal(valuer:ContentValues, selec: String, seArgs: Array<String>):Int{
        val id=sqlBD !!.update (dbTableRhal ,valuer,selec,seArgs)

        return id


    }


    fun upDateHgaz(valuer:ContentValues, selec: String, seArgs: Array<String>):Int{
        val id=sqlBD !!.update (dbTablhaltz ,valuer,selec,seArgs)

        return id


    }


}

