package com.example.value.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Vladimir Stebakov on 03.08.2022
 */
@Database(entities = [ValueDb::class], version = 1)
abstract class ValueDatabase : RoomDatabase() {
    abstract fun valueDao(): ValueDao

    companion object {
        fun getInstance(context: Context): ValueDatabase =
            Room.databaseBuilder(context, ValueDatabase::class.java, "database").build()
    }
}