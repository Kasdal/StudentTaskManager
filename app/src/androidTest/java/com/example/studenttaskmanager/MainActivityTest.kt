/*
package com.example.studenttaskmanager

import android.widget.Button
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testApplicationContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.studenttaskmanager", appContext.packageName)
    }

    @Test
    fun testOnCreate() {
        // TODO: Create an instance of the MainActivity and call onCreate()

        // Verify that the content view is set
        val activity = MainActivity()
        activity.onCreate(null)
        assertNotNull(activity.findViewById<Button>(R.id.button))
    }

        // Verify that the OnClickListener is attached to the newTaskButton
        val newTaskButton = activity.findViewById<Button>(R.id.newTaskButton)
        assertNotNull(newTaskButton.getOnClickListener())

        // Verify that the setRecyclerView() method is called
        // TODO: Add a way to verify that setRecyclerView() is called
    }

    @Test
    fun testOnOptionsItemSelected() {



// Verify that a Toast message is shown

        // Verify that the correct menu item is selected

        // Verify that the correct action is taken for each menu item

    }


@Test
fun testEditTaskItem() {

    // Create a TaskItemModel to edit
    val taskItem = TaskItemModel("Task 1", "Description 1", 2,3,1)


    // Call the editTaskItem() method
    activity.editTaskItem(taskItem)

    // Verify that the NewTask fragment is opened with the correct TaskItemModel as an argument
    // TODO: Add a way to verify that the NewTask fragment is opened with the correct TaskItemModel
}

@Test
fun testCompleteTaskItem() {
    // TODO: Create an instance of the MainActivity and call onCreate()

    // Create a TaskItemModel to complete
    val taskItem = TaskItemModel("Task 1", "Description 1", 2,3,1)

    // Call the completeTaskItem() method
    activity.completeTaskItem(taskItem)

    // Verify that the TaskItemModel is marked as completed and the RecyclerView is updated
    // TODO: Add a way to verify that the TaskItemModel is marked as completed and the RecyclerView is updated


}

*/
