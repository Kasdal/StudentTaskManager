package com.example.studenttaskmanager

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeDao {

    // Fake implementation of the TaskDao used by the FakeRepo
    class FakeDao(private val tasks: List<TaskItemModel>) : TaskDao {

        override fun allTaskItems(): Flow<List<TaskItemModel>> {
            return flow { emit(tasks) }
        }

        override suspend fun insertTaskItem(taskItem: TaskItemModel) {
            // No-op
        }

        override suspend fun updateTaskItem(taskItem: TaskItemModel) {
            // No-op
        }

        override suspend fun deleteTaskItem(taskItem: TaskItemModel) {
            // No-op
        }
    }
}