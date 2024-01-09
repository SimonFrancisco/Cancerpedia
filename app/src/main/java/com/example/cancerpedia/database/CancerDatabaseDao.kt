package com.example.cancerpedia.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CancerDatabaseDao {
    /*@Query("SELECT * FROM cancer")
    fun getAll():List<Cancer?>?*/
    @Query("SELECT * from cancer WHERE id =:key")
    fun get(key:Int):Cancer
    // Getting everything from our database
    @Query("SELECT * from cancer ORDER BY id ASC")
    fun getAllCancers():LiveData<List<Cancer>>

}