package com.example.tema1_android.data.tasks

import android.os.AsyncTask
import com.example.tema1_android.ApplicationController
import com.example.tema1_android.data.models.AnimalDbModel

class UpdateAnimalTask(private val onSuccess: () -> Unit) : AsyncTask<AnimalDbModel, Unit, Unit>() {
    override fun doInBackground(vararg params: AnimalDbModel) {
        params.getOrNull(0)?.let { it ->
            ApplicationController.instance.projectDatabase.animalDao.update(it)
        }
    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        onSuccess()
    }
}