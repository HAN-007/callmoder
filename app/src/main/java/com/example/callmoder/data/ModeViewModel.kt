package com.example.callmoder.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ModeViewModel(application:Application):AndroidViewModel(application) {

    private val readAllData: LiveData<List<Mode>>
    private val repository: ModeRepository

    init {
        val modeDao = ModeDatabase.getDatabase(application).modeDao()
        repository = ModeRepository(modeDao)
        readAllData = repository.readAllData
    }

    fun addMode(mode:Mode){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMode(mode)
        }
    }
}