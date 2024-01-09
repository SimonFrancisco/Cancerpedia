package com.example.cancerpedia.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cancer::class], exportSchema = false, version = 1)
abstract class CancerDataBase: RoomDatabase() {
    abstract fun cancerDao(): CancerDatabaseDao
    companion object{
        @Volatile
        private var INSTANCE:CancerDataBase? = null
        fun getDatabase(context:Context):CancerDataBase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        CancerDataBase::class.java,
                        "cancer_database")
                        .fallbackToDestructiveMigration()
                        .createFromAsset("database/cancer.db") // accessing existing database
                        .build()
                    INSTANCE = instance

                }
                return instance
            }
        }
    }
}