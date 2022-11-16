package com.example.studenttaskmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class ViewTaskModel : ViewModel()
{
    var taskItems = MutableLiveData<MutableList<TaskItemModel>>()
//initialise the list of tasks
    init {
        taskItems.value = mutableListOf()
    }

    fun addTaskItem(newTask: TaskItemModel)
    {
        val list = taskItems.value
        list!!.add(newTask)
        taskItems.postValue(list)
    }

    //TODO broken - fix this function later

//    fun updateTaskItem(id: UUID, name: String, desc: String, dueTime: LocalTime?)
//    {
//        val list = taskItems.value
//        //find the task with the given id
//        val task = list!!.find { it.id == id }!!
//        //update the task with the new values passed in the parameters of the function call
//        task.name = name
//        task.desc = desc
//        task.dueTime = dueTime
//        //update the list of tasks with the new task values and post the new list of tasks
//        taskItems.postValue(list)
//    }
//
//    fun setCompleted(taskItem: TaskItemModel)
//    {
//        //get the list of tasks from the live data object taskItems and store it in a variable
//        val list = taskItems.value
//        //find the task with the given id
//        val task = list!!.find { it.id == taskItem.id }!!
//        //if the task is not completed, set the completed date to the current date
//        if (task.completedDate == null)
//            task.completedDate = LocalDate.now()
//        //update the list of tasks with the new task values and post the new list of tasks
//        taskItems.postValue(list)
//    }

    fun updateTaskItem(id: TaskItemModel) {
        //TODO: implement this function

    }


}