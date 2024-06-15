package com.example.tema1_android.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ContinentDbModel.Table_NAME)
class ContinentDbModel(
    @PrimaryKey
    @ColumnInfo(name = ARG_CONTINENT_NAME)
    val name: String
) {
    companion object {
        const val Table_NAME = "continents"
        const val ARG_CONTINENT_NAME = "continent_name"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ContinentDbModel) return false

        if (name != other.name) return false

        return true
    }
}