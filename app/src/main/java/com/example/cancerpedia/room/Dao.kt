package com.example.cancerpedia.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM cancer")
    fun getAll():List<Cancer?>?
}