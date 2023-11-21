package com.example.cancerpedia.database

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: vars 
@Entity(tableName = "cancer")
class Cancer(
    var img: String,
    var title: String,
    var des: String,
    var ing: String,
    var category: String) {
    @JvmField
    @PrimaryKey(autoGenerate = true)
    var uid=0
}