package com.example.studenttaskmanager

interface TaskItemListener
{
    fun editTaskItem(taskItem: TaskItemModel)
    fun completeTaskItem(taskItem: TaskItemModel)
    //fun deleteTaskItem(taskItem: TaskItemModel)
}