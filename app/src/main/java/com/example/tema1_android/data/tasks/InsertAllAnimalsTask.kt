package com.example.tema1_android.data.tasks

import android.os.AsyncTask
import com.example.tema1_android.ApplicationController
import com.example.tema1_android.data.models.AnimalDbModel
import com.example.tema1_android.data.models.ContinentDbModel

class InsertAllAnimalsTask(
    private val onSuccess: () -> Unit,
) : AsyncTask<List<AnimalDbModel>, Unit, Unit>() {
    override fun doInBackground(vararg params: List<AnimalDbModel>) {
        params.getOrNull(0)?.let { animalList ->
            ApplicationController.instance.projectDatabase.animalDao.insertAll(animalList)

            animalList.groupBy { it.continent }
                .forEach{(continent, animals) ->
                    ApplicationController.instance.projectDatabase.continentDao.insert(
                        ContinentDbModel(name = continent))
                    }
        }
    }

    override fun onPostExecute(result: Unit) {
        onSuccess()
    }
}