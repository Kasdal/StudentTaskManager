package com.example.studenttaskmanager

import androidx.room.*
import kotlinx.coroutines.flow.Flow
@Dao
interface TaskDao {
        //Select all tasks from the task table and order them by ID in ascending order
        @Query("SELECT * FROM task_item_table ORDER BY id ASC")
        //Return a flow of a list of task items
        fun allTaskItems(): Flow<List<TaskItemModel>>
        //Insert a task item into the task table and replace it if it already exists in the table (onConflict)
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertTaskItem(taskItem: TaskItemModel)
        //Update a task item in the task table
        @Update
        suspend fun updateTaskItem(taskItem: TaskItemModel)
        //Delete a task item from the task table
        @Delete
        suspend fun deleteTaskItem(taskItem: TaskItemModel)
}