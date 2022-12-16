package com.example.studenttaskmanager

import android.app.Application

class TaskApplication: Application() {
    private val database by lazy { TasksDB.getDatabase(this) }
    val repository by lazy { TaskRepo(database.taskDao()) }

}
