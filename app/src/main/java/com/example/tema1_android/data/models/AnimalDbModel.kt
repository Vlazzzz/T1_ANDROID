package com.example.tema1_android.data.models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AnimalDbModel.TABLE_NAME)
class AnimalDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = ARG_ANIMAL_NAME)
    val name: String,

    @ColumnInfo(name = ARG_ANIMAL_CONTINENT)
    var continent: String
) {
    companion object{
        const val TABLE_NAME = "animals"
        const val ARG_ANIMAL_NAME = "animal_name"
        const val ARG_ANIMAL_CONTINENT = "animal_continent"
    }
}