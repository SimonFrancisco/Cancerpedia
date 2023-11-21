package com.example.cancerpedia.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM cancer")
    fun getAll():List<Cancer?>?
}