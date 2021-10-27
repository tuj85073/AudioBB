package edu.temple.audiobb

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import edu.temple.audiobb.Book

class TheApplication: Application() {



    var  db: SQLiteDatabase?=null;

    var instance: TheApplication? = null
    override fun onCreate() {
        super.onCreate()
        instance = this

    }

}