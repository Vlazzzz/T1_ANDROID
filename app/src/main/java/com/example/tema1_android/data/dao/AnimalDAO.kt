package com.example.tema1_android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tema1_android.data.models.AnimalDbModel

@Dao
interface AnimalDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(animal: AnimalDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(animal: List<AnimalDbModel>)

    @Query("SELECT * FROM ${AnimalDbModel.TABLE_NAME}")
    fun getAll(): List<AnimalDbModel>
}