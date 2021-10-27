package com.example.signupandsignin.Model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,"Users",null,1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0!=null){
            p0.execSQL("create table Users(id integer primary key ,name text,mobile integer UNIQUE ,location text,password text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) { }
    fun addUser(name:String,mobile:Int,location:String,password:String): Long {
        val cv=ContentValues()
        cv.put("name",name)
        cv.put("mobile",mobile)
        cv.put("location",location)
        cv.put("password",password)
        return this.writableDatabase.insert("Users",null,cv)
    }
    fun getUsers(mobileUser:Int,passwordUser: String): User? {

            val cursor:Cursor=this.writableDatabase.query("Users",null,"mobile=?", arrayOf(mobileUser.toString()),null,null,null)
            if(cursor.moveToFirst()) {
                lateinit var user: User
                val mobile = cursor.getInt(cursor.getColumnIndex("mobile"))
                val password = cursor.getString(cursor.getColumnIndex("password"))
                if (mobileUser == mobile && passwordUser == password) {
                    val id = cursor.getInt(cursor.getColumnIndex("id"))
                    val name = cursor.getString(cursor.getColumnIndex("mobile"))
                    val location = cursor.getString(cursor.getColumnIndex("location"))
                    user = User(id, name, mobile, location, passwordUser)
                    return user
                }
            }

                return null



    }
}