package com.example.tema1_android.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tema1_android.data.dao.AnimalDAO
import com.example.tema1_android.data.dao.ContinentDAO
import com.example.tema1_android.data.models.AnimalDbModel
import com.example.tema1_android.data.models.ContinentDbModel

@Database(entities = [AnimalDbModel::class, ContinentDbModel::class], version = 1)
abstract class ProjectDatabase: RoomDatabase() {
    abstract val animalDao : AnimalDAO
    abstract val continentDao : ContinentDAO
}