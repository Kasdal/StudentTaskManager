package com.example.studenttaskmanager

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class ViewTaskModel( private val repository: TaskRepo ): ViewModel()
{
    val taskItems: LiveData<List<TaskItemModel>> = repository.allTaskItems.asLiveData()

    fun addTaskItem(taskItem: TaskItemModel) = viewModelScope.launch {
        repository.insertTaskItem(taskItem)
    }

    fun updateTaskItem(taskItem: TaskItemModel) = viewModelScope.launch {
        repository.updateTaskItem(taskItem)
    }

    fun setCompleted(taskItem: TaskItemModel) = viewModelScope.launch {
        if (!taskItem.isCompleted())
            taskItem.completedDateString = TaskItemModel.dateFormatter.format(LocalDate.now())
        repository.updateTaskItem(taskItem)
    }

    fun deleteTaskItem(taskItem: TaskItemModel) {
        viewModelScope.launch {
            repository.deleteTaskItem(taskItem)
        }
    }
}

class TaskItemModelFactory(private val repository: TaskRepo) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(ViewTaskModel::class.java))
            return ViewTaskModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}