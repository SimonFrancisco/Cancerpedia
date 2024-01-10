package com.example.cancerpedia.cancerscreens.cancerpedia

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cancerpedia.database.Cancer
import com.example.cancerpedia.database.CancerDataBase

class CancerViewModel(application: Application):AndroidViewModel(application) {
    val getAllCancer:LiveData<List<Cancer>>
    private val repository: CancerRepository

    init {
        val cancerDao = CancerDataBase.getDatabase(application).cancerDao()
        repository = CancerRepository(cancerDao)
        getAllCancer = repository.getAllCancers
    }
}