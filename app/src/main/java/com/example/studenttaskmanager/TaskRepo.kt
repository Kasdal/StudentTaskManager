package com.example.studenttaskmanager

import androidx.annotation.WorkerThread
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
class TaskRepo( private val taskDao: TaskDao ) {

    val allTaskItems: Flow<List<TaskItemModel>> = taskDao.allTaskItems()

    @WorkerThread
    suspend fun insertTaskItem(taskItem: TaskItemModel)
    {
        taskDao.insertTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun updateTaskItem(taskItem: TaskItemModel)
    {
        taskDao.updateTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun deleteTaskItem(taskItem: TaskItemModel)
    {
        taskDao.deleteTaskItem(taskItem)
    }

}