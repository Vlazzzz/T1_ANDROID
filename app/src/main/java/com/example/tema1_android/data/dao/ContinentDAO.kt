package com.example.tema1_android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tema1_android.data.models.AnimalDbModel
import com.example.tema1_android.data.models.ContinentDbModel

@Dao
interface ContinentDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(continent: ContinentDbModel)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertAll(continent: List<ContinentDbModel>)

    @Query ("SELECT * FROM ${ContinentDbModel.Table_NAME}")
    fun getAll(): List<ContinentDbModel>
}