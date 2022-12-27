package com.example.callmoder.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mode_table")
data class Mode(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val modeName:String,
    val smsContent:String,
    val selectedTime:Int
)