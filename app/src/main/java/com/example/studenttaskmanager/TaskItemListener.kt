package com.example.studenttaskmanager

interface TaskItemListener
{
    fun editTaskItem(taskItem: TaskItemModel)
    fun completeTaskItem(taskItem: TaskItemModel)
    //Todo: Add a method to delete a task item
    //fun deleteTaskItem(taskItem: TaskItemModel)
    //Todo: Sorting methods
    //fun sortTaskItem(taskItem: TaskItemModel)
    //Todo: Filter methods
    //fun filterTaskItem(taskItem: TaskItemModel)
    //Todo: Search methods
    //fun searchTaskItem(taskItem: TaskItemModel)
}