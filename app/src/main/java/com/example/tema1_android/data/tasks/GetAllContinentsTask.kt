package com.example.tema1_android.data.tasks

import android.os.AsyncTask
import com.example.tema1_android.ApplicationController
import com.example.tema1_android.data.models.ContinentDbModel

class GetAllContinentsTask(
    private val onSuccess: (List<ContinentDbModel>) -> Unit,
) : AsyncTask<Unit, Unit, List<ContinentDbModel>>() {
    override fun doInBackground(vararg params: Unit): List<ContinentDbModel> {
        return ApplicationController.instance.projectDatabase.continentDao.getAll()
    }

    override fun onPostExecute(result: List<ContinentDbModel>) {
        onSuccess(result)
    }
}