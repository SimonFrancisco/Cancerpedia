package com.example.cancerpedia.cancerDataClasses

object CancerMenu {
    private lateinit var cancersList: ArrayList<Cancer>

    fun getList():ArrayList<Cancer> {
        return cancersList
    }

    fun menuFormation() {
        //-заполнение списка объектами класса Cancer с данными из json(?)
    }
}