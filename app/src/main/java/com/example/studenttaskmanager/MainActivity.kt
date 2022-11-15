package com.example.studenttaskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studenttaskmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskItemListener
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewTaskModel: ViewTaskModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        //implements splash screen for app based on google recommendations this is the best way to implement splash screen.
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewTaskModel = ViewModelProvider(this).get(ViewTaskModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewTask(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
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

    fun onGroupItemClick(item: MenuItem) {

        // One of the group items (using the onClick attribute) was clicked
        // The item parameter passed here indicates which item it is
        // All other menu item clicks are handled by <code><a href="/reference/android/app/Activity.html#onOptionsItemSelected(android.view.MenuItem)">onOptionsItemSelected()</a></code>
        TODO() //Implement menu functionality for sorting tasks
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