package com.example.cancerpedia.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cancer")
data class Cancer(
    @PrimaryKey(autoGenerate = true)
    var cancerId:Int,
    var name: String,
    var def: String,
    var types: String,
    var sympt: String,
    var stage:String,
    var cause:String,
    var diagn:String,
    var treat:String) {

}