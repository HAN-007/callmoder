package com.example.callmoder.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Mode::class], version = 1, exportSchema = false)
abstract class ModeDatabase:RoomDatabase() {

    abstract fun modeDao():ModeDao

    companion object{
        @Volatile
        private var INSTANCE:ModeDatabase? = null

        fun getDatabase(context: Context):ModeDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ModeDatabase::class.java,
                    "mode_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}