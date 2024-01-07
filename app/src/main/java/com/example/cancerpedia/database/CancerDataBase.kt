package com.example.cancerpedia.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Cancer::class], exportSchema = false, version = 1)
abstract class CancerDataBase: RoomDatabase() {
    abstract fun getDao(): CancerDatabaseDao
}