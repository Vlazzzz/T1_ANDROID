package com.example.tema1_android.data.repositories

import com.example.tema1_android.data.models.ContinentDbModel
import com.example.tema1_android.data.tasks.GetAllContinentsTask
import com.example.tema1_android.data.tasks.InsertAllContinentsTask
import com.example.tema1_android.data.tasks.InsertContinentTask

object ContinentRepository {
    fun insertContinent(continent: ContinentDbModel, onSuccess: () -> Unit) {
        InsertContinentTask(onSuccess).execute(continent)
    }

    fun insertAllContinents(continentList: List<ContinentDbModel>, onSuccess: () -> Unit) {
        InsertAllContinentsTask(onSuccess).execute(continentList)
    }

    fun getAllContinents(onSuccess: (List<ContinentDbModel>) -> Unit) {
        GetAllContinentsTask(onSuccess).execute()
    }
}