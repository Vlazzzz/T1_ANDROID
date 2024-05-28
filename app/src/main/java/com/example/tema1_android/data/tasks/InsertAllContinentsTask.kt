package com.example.tema1_android.data.tasks

import android.os.AsyncTask
import com.example.tema1_android.ApplicationController
import com.example.tema1_android.data.models.ContinentDbModel

class InsertAllContinentsTask(
    private val onSuccess:() -> Unit,
) : AsyncTask<List<ContinentDbModel>, Unit, Unit>() {
    override fun doInBackground(vararg params: List<ContinentDbModel>) {
        params.getOrNull(0)?.let { continentList ->
            ApplicationController.instance.projectDatabase.continentDao.insertAll(continentList)
            }
        }
    override fun onPostExecute(result: Unit) {
        onSuccess()
    }
}