package com.example.studenttaskmanager

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.studenttaskmanager.databinding.TaskItemCellBinding
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemListener
): RecyclerView.ViewHolder(binding.root)
{
    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    fun bindTaskItem(taskItem: TaskItemModel)
    {
        binding.name.text = taskItem.name


        if (taskItem.isCompleted()){
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        binding.completeButton.setOnClickListener{
            clickListener.completeTaskItem(taskItem)
        }

        //Edit tasks after holding down on them for 1 second
        binding.root.setOnLongClickListener{
            clickListener.editTaskItem(taskItem)
            true
        }
        //If a task is completed, change the taskCellContainer background to a light green color
        if (taskItem.isCompleted()){
            binding.taskCellContainer.setBackgroundColor(context.getColor(R.color.light_green))
        }
        else{
            binding.taskCellContainer.setBackgroundColor(context.getColor(R.color.white))
        }

        //If the task has a due time, display it, otherwise hide the dueTime TextView
        if (taskItem.dueTime() != null){
            binding.dueTime.text = taskItem.dueTime()!!.format(timeFormat)
            binding.dueTime.visibility = android.view.View.VISIBLE
        }
        else{
            binding.dueTime.visibility = android.view.View.GONE
        }

        //If the task has been completed hide the dueTime TextView
        if (taskItem.isCompleted()){
            binding.dueTime.visibility = android.view.View.GONE
        }

        if(taskItem.dueTime() != null)
            binding.dueTime.text = timeFormat.format(taskItem.dueTime())
        else
            binding.dueTime.text = ""

        //If the task due is greater 1 minute, shake the taskCellContainer
        if (taskItem.dueTime() != null && taskItem.dueTime()!!.isAfter(LocalTime.now().plusMinutes(10))){
            binding.taskCellContainer.startAnimation(android.view.animation.AnimationUtils.loadAnimation(context, R.anim.shake))
        }
        else{
            binding.taskCellContainer.clearAnimation()
        }
    }
}