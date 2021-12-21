package com.example.videoplaydemo.data

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.videoplaydemo.data.Person

@Dao
interface PersonDAO {
    @Insert
    fun insert(person: Person): Long

    @Query("SELECT * FROM person_info")
    fun fillAll():Cursor

}