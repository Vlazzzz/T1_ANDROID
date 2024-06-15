package com.example.tema1_android.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.tema1_android.data.models.AnimalDbModel

@Dao
interface AnimalDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(animal: AnimalDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(animal: List<AnimalDbModel>)

    @Query("SELECT * FROM ${AnimalDbModel.TABLE_NAME}")
    fun getAll(): List<AnimalDbModel>

    @Update
    fun update(animal: AnimalDbModel)

    @Delete
    fun delete(animal: AnimalDbModel)
}