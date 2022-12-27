package com.example.callmoder.data

import androidx.lifecycle.LiveData

class ModeRepository(private val modeDao: ModeDao) {
    val readAllData:LiveData<List<Mode>> = modeDao.readAllData()
    suspend fun addMode(mode:Mode){
        modeDao.addMode(mode)
    }
}