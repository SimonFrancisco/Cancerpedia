package com.example.cancerpedia.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
@kotlinx.parcelize.Parcelize
@Entity(tableName = "cancer")
data class Cancer(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var name: String,
    var def: String,
    var types: String,
    var sympt: String,
    var stage:String,
    var cause:String,
    var diagn:String,
    var treat:String):Parcelable
