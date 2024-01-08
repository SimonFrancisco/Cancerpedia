package com.example.cancerpedia.cancerscreens

import androidx.lifecycle.LiveData
import com.example.cancerpedia.database.Cancer
import com.example.cancerpedia.database.CancerDatabaseDao

class CancerRepository(private val cancerDatabaseDao:CancerDatabaseDao) {
    val getAllCancers: LiveData<List<Cancer>> = cancerDatabaseDao.getAllCancers()

}