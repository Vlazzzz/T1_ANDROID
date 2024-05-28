package com.example.tema1_android.data.repositories

import com.example.tema1_android.data.models.AnimalDbModel
import com.example.tema1_android.data.tasks.DeleteAnimalTask
import com.example.tema1_android.data.tasks.GetAllAnimalsTask
import com.example.tema1_android.data.tasks.InsertAllAnimalsTask
import com.example.tema1_android.data.tasks.InsertAnimalTask

object AnimalRepository {
    fun insertAnimal(animal: AnimalDbModel, onSuccess: () -> Unit) {
        InsertAnimalTask(onSuccess).execute(animal)
    }

    fun insertAllAnimals(animalList: List<AnimalDbModel>, onSuccess: () -> Unit) {
        InsertAllAnimalsTask(onSuccess).execute(animalList)
        }

    fun getAllAnimals(onSuccess: (List<AnimalDbModel>) -> Unit) {
        GetAllAnimalsTask(onSuccess).execute()
    }

    fun deleteAnimal(animal: AnimalDbModel, onSuccess: () -> Unit) {
        DeleteAnimalTask(onSuccess).execute(animal)
    }
}