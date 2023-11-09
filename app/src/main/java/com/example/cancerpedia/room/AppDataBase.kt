package com.example.cancerpedia.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Cancer::class], exportSchema = false, version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getDao(): Dao
}