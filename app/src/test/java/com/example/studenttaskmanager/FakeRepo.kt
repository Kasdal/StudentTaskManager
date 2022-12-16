/*
package com.example.studenttaskmanager

import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

// Fake implementation of the TaskRepo
class FakeRepo(private val tasks: MutableList<TaskItemModel> = mutableListOf()) : TaskRepo(FakeDao(tasks)) {

    // Keep track of the number of times each method is called
    var insertTaskItemCalls = 0
    var updateTaskItemCalls = 0
    var deleteTaskItemCalls = 0

    override suspend fun insertTaskItem(taskItem: TaskItemModel) {
        insertTaskItemCalls++
        tasks.add(taskItem)
    }

    override suspend fun updateTaskItem(taskItem: TaskItemModel) {
        updateTaskItemCalls++
        tasks.removeIf { it.id == taskItem.id }
        tasks.add(taskItem)
    }

    override suspend fun deleteTaskItem(taskItem: TaskItemModel) {
        deleteTaskItemCalls++
        tasks.removeIf { it.id == taskItem.id }
    }
}

// Tests for the FakeRepo
@Test
fun testFakeRepo() = runBlocking {

    // Create an instance of the FakeRepo
    val repo = FakeRepo()

    // Check the initial state of the FakeRepo
    Assert.assertEquals(0, repo.insertTaskItemCalls)
    Assert.assertEquals(0, repo.updateTaskItemCalls)
    Assert.assertEquals(0, repo.deleteTaskItemCalls)
    Assert.assertEquals(0, repo.allTaskItems.first().size)

    // Add a task
    val task1 = TaskItemModel("Task 1")
    repo.insertTaskItem(task1)
    Assert.assertEquals(1, repo.insertTaskItemCalls)
    Assert.assertEquals(1, repo.allTaskItems.first().size)
    Assert.assertEquals(task1, repo.allTaskItems.first().first())

    // Update the task
    val task1Updated = TaskItemModel(id = task1.id, description = "Task 1 Updated")
    repo.updateTaskItem(task1Updated)
    Assert.assertEquals(1, repo.updateTaskItemCalls)
    Assert.assertEquals(1, repo.allTaskItems.first().size)
    Assert.assertEquals(task1Updated, repo.allTaskItems.first().first())

    // Delete the task
    repo.deleteTaskItem(task1Updated)
    Assert.assertEquals(1, repo.deleteTaskItemCalls)
    Assert.assertEquals(0, repo.allTaskItems.first().size)
}



*/
