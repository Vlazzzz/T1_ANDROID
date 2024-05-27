package com.example.tema1_android.data.models
import androidx.room.Embedded
import androidx.room.Relation

class ContinentWithAnimals(
    @Embedded
    val continent: ContinentDbModel,
    @Relation(
        parentColumn = ContinentDbModel.ARG_CONTINENT_NAME,
        entityColumn = AnimalDbModel.ARG_ANIMAL_CONTINENT
    )
    val animals: List<AnimalDbModel>
)