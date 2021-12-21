package com.example.videoplaydemo.data

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(Person::class), version = 1)
abstract class PersonDatabase: RoomDatabase() {
    companion object{
        lateinit var INSTANCE: PersonDatabase
        var DATABASE_NAME:String = "testdb"
    }
    private fun getInstance(context: Context): PersonDatabase {
        if (INSTANCE ==null){
            INSTANCE = Room
                .databaseBuilder(context, PersonDatabase::class.java, DATABASE_NAME)
                .build()
        }
        return INSTANCE
    }

    abstract fun getPersonDAO(): PersonDAO
}