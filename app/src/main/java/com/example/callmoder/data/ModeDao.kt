package com.example.callmoder.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ModeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMode(modes: Mode)

    @Query("SELECT * FROM mode_table ORDER BY id ASC")
    fun readAllData():LiveData<List<Mode>>

}