package com.example.tema1_android.data.tasks

import android.os.AsyncTask
import com.example.tema1_android.ApplicationController
import com.example.tema1_android.data.models.AnimalDbModel

class GetAllAnimalsTask(
    private val onSuccess: (List<AnimalDbModel>) -> Unit,
) : AsyncTask<Unit, Unit, List<AnimalDbModel>>() {
    override fun doInBackground(vararg params: Unit): List<AnimalDbModel> {
        return ApplicationController.instance.projectDatabase.animalDao.getAll()
    }

    override fun onPostExecute(result: List<AnimalDbModel>) {
        onSuccess(result)
    }
}