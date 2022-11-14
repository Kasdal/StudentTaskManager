package com.example.studenttaskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.studenttaskmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewTaskModel: ViewTaskModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewTaskModel = ViewModelProvider (this).get(ViewTaskModel::class.java)
        //When the user clicks this will open the add task activity
        binding.newTaskButton.setOnClickListener {
            NewTask().show(supportFragmentManager, "NewTaskDialogFragment")
        }
        viewTaskModel.name.observe(this) {
            binding.taskName.text = String.format("Task Name: %s", it)
        }

        viewTaskModel.description.observe(this) {
            binding.taskDesc.text = String.format("Task Description: %s", it)
        }
    }
}