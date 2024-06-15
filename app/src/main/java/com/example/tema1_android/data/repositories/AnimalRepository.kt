package com.example.tema1_android.data.repositories

import com.example.tema1_android.data.models.AnimalDbModel
import com.example.tema1_android.data.tasks.DeleteAnimalTask
import com.example.tema1_android.data.tasks.GetAllAnimalsTask
import com.example.tema1_android.data.tasks.InsertAllAnimalsTask
import com.example.tema1_android.data.tasks.InsertAnimalTask
import com.example.tema1_android.data.tasks.UpdateAnimalTask

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

    fun updateAnimal(animal: AnimalDbModel, onSuccess: () -> Unit) {
        UpdateAnimalTask(onSuccess).execute(animal)
    }

    fun deleteAnimal(animal: AnimalDbModel, onSuccess: () -> Unit) {
        DeleteAnimalTask(onSuccess).execute(animal)
    }
}