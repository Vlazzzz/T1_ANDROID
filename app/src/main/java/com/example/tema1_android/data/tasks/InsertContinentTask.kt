package com.example.tema1_android.data.tasks

import android.os.AsyncTask
import com.example.tema1_android.ApplicationController
import com.example.tema1_android.data.database.ProjectDatabase
import com.example.tema1_android.data.models.ContinentDbModel

class InsertContinentTask(
    private val onSuccess: () -> Unit,
) : AsyncTask<ContinentDbModel, Unit, Unit>() {
    override fun doInBackground(vararg params: ContinentDbModel) {
        params.forEach { continent ->
            params.getOrNull(0)?.let { continent ->
                ApplicationController.instance.projectDatabase.continentDao.insert(continent)
            }
        }
    }

    override fun onPostExecute(result: Unit) {
        onSuccess()
    }
}