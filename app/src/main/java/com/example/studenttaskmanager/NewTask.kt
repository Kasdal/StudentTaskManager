package com.example.studenttaskmanager

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.studenttaskmanager.databinding.FragmentNewTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.time.LocalTime

//This will set this fragment to be a bottom sheet
class NewTask(var taskItem: TaskItemModel?) : BottomSheetDialogFragment()
{
    private lateinit var binding: FragmentNewTaskBinding
    private lateinit var viewTaskModel: ViewTaskModel
    private var dueTime: LocalTime? = null
    private lateinit var builder : AlertDialog.Builder

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (taskItem != null)
        {
            binding.taskTitle.text = "Edit Task"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(taskItem!!.name)
            binding.desc.text = editable.newEditable(taskItem!!.desc)
            if(taskItem!!.dueTime() != null){
                dueTime = taskItem!!.dueTime()!!
                updateTimeButtonText()
            }
        }
        else
        {
            binding.taskTitle.text = "New Task"
        }

        viewTaskModel = ViewModelProvider(activity).get(ViewTaskModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
        binding.timePickerButton.setOnClickListener {
            openTimePicker()
        }
    }

    private fun openTimePicker() {
        if(dueTime == null)
            dueTime = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener{ _, selectedHour, selectedMinute ->
            dueTime = LocalTime.of(selectedHour, selectedMinute)
            updateTimeButtonText()
        }
        val dialog = TimePickerDialog(activity, listener, dueTime!!.hour, dueTime!!.minute, true)
        dialog.setTitle("Task Due")
        dialog.show()

    }

    private fun updateTimeButtonText() {
        binding.timePickerButton.text = String.format("%02d:%02d",dueTime!!.hour,dueTime!!.minute)
        //add alert dialog to confirm time
        builder = AlertDialog.Builder(activity)
        builder.setTitle("Confirm Time")
        builder.setMessage("Are you sure you want to set the time to ${dueTime!!.hour}:${dueTime!!.minute}?")
        builder.setPositiveButton("Yes"){dialog, which ->
            //do nothing
        }
        builder.setNegativeButton("No"){dialog, which ->
            //do nothing
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    //TODO: Add validation
    private fun saveAction()
    {
        //New formated due time string using the formatter in TaskItemModel
        val dueTimeString = if(dueTime == null) null else TaskItemModel.timeFormatter.format(dueTime)
        val name = binding.name.text.toString()
        val desc = binding.desc.text.toString()
        if(taskItem == null)
        {
            val newTask = TaskItemModel(name,desc,dueTimeString,null)
            viewTaskModel.addTaskItem(newTask)
        }
        else
        {
            taskItem!!.name = name
            taskItem!!.desc = desc
            taskItem!!.dueTimeString = dueTimeString
            viewTaskModel.updateTaskItem(taskItem!!)
        }
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()

        //add alert dialog to confirm save
        builder = AlertDialog.Builder(activity)
        builder.setTitle("Confirm Save")
        builder.setMessage("Are you sure you want to save this task?")
        builder.setPositiveButton("Yes"){dialog, which ->
            //do nothing
        }
        builder.setNegativeButton("No"){dialog, which ->
            //do nothing
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }
}
