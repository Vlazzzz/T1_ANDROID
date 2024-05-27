package com.example.tema1_android

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tema1_android.data.database.ProjectDatabase

class ApplicationController:Application() {
    companion object {
        lateinit var instance: ApplicationController
            private set
    }

    lateinit var projectDatabase: ProjectDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        setUpDatabase()
    }

    private fun setUpDatabase(){
        projectDatabase = Room.databaseBuilder(
            applicationContext,
            ProjectDatabase::class.java,
            "project_database"
        ).build()
    }
}