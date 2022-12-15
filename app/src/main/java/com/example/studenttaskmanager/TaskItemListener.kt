package com.example.studenttaskmanager

interface TaskItemListener
{
    fun editTaskItem(taskItem: TaskItemModel)
    fun completeTaskItem(taskItem: TaskItemModel)
    //Search tasks by passing in a string to search for in the task name and return a list of tasks that match the search string
    //fun searchTasks(searchString: String): List<TaskItemModel>
}