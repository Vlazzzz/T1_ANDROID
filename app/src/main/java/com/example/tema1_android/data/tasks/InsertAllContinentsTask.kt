package com.example.tema1_android.data.tasks

import android.os.AsyncTask
import com.example.tema1_android.data.models.ContinentDbModel

class InsertAllContinentsTask(
    private val onSuccess:() -> Unit,
) : AsyncTask<ContinentDbModel, Unit, Unit>() {
    override fun doInBackground(vararg params: List) {
}