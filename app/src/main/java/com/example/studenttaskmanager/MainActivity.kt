package com.example.studenttaskmanager

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studenttaskmanager.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), TaskItemListener
{
    private lateinit var binding: ActivityMainBinding
    private val viewTaskModel: ViewTaskModel by viewModels {
        TaskItemModelFactory((application as TaskApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        //implements splash screen for app based on google recommendations this is the best way to implement splash screen.
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // viewTaskModel = ViewModelProvider(this).get(ViewTaskModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewTask(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
        val swipeGesture = object : SwipeGesture() {
            override fun onSwiped(viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, direction: Int)
            {
                val taskItem = viewTaskModel.taskItems.value?.get(viewHolder.adapterPosition)
                if (taskItem != null)
                    viewTaskModel.deleteTaskItem(taskItem)
                Snackbar.make(binding.root, "Task Deleted", Snackbar.LENGTH_LONG).apply {
                    setAction("Undo") {
                        viewTaskModel.addTaskItem(taskItem!!)
                    }
                    show()
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeGesture)
        itemTouchHelper.attachToRecyclerView(binding.taskListRecyclerView)
    }

    private fun setRecyclerView()
    {
        val mainActivity = this
        viewTaskModel.taskItems.observe(this){
            binding.taskListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it, mainActivity)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.searchByName -> {
                viewTaskModel.sortByName()
                Toast.makeText(this, "Sorted by Name", Toast.LENGTH_SHORT).show()
        }
            R.id.sortByDueTime -> {
                viewTaskModel.sortByDueTime()
                Toast.makeText(this, "Sorted by Date", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun editTaskItem(taskItem: TaskItemModel)
    {
        NewTask(taskItem).show(supportFragmentManager,"newTaskTag")
    }

    override fun completeTaskItem(taskItem: TaskItemModel)
    {
        viewTaskModel.setCompleted(taskItem)
    }
}