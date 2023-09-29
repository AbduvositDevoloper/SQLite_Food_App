package com.uz.sqlitefoodapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.uz.sqlitefoodapp.model.User

class MyDbHelper(

    context: Context

) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION), MyInterface {

    companion object {
        const val DB_NAME: String = "contact.db"
        const val DB_VERSION: Int = 1


        const val USER_TABLE = "contact_table"
        const val USER_ID = "id"
        const val USER_NAME = "name"
        const val USER_MAHSULOT = "mahsulot"
        const val USER_TAYYORLASH = "tayyorlash"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "create table $USER_TABLE($USER_ID integer not null primary key autoincrement unique, $USER_NAME text not null, $USER_MAHSULOT text not null, $USER_TAYYORLASH text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists $USER_TABLE")

        onCreate(p0)
    }


    //Interface
    override fun addUser(user: User) {
        val dataBase = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(USER_NAME, user.name)
        contentValue.put(USER_MAHSULOT, user.mahsulotlar)
        contentValue.put(USER_TAYYORLASH, user.tayTartibi)
        dataBase.insert(USER_TABLE, null, contentValue)

    }

    override fun getAllTaom(): List<User> {
        val list = ArrayList<User>()

        val database = this.readableDatabase
        val query = "select * from $USER_TABLE"
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()){
            do{
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val mah = cursor.getString(2)
                val tay = cursor.getString(3)
                val user = User(id, name, mah, tay)
                list.add(user)
            }while (cursor.moveToNext())
        }

        return list
    }

    override fun deleteUser(user: User) {

    }

    override fun update(user: User) {
        TODO("Not yet implemented")
    }
}