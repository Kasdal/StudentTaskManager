package com.example.studenttaskmanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskItemModel::class], version = 1 , exportSchema = false)
abstract class TasksDB : RoomDatabase(){

    abstract fun taskDao(): TaskDao
    // Singleton prevents multiple instances of database opening at the same time.
    companion object
    {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: TasksDB? = null
        // Get the database instance. If the database has not been created, it will be created. If it has been created, it will be returned.
        fun getDatabase(context: Context): TasksDB
        {
            return INSTANCE ?: synchronized(this)
            {
                // Create database here if it does not exist yet.
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TasksDB::class.java,
                    // Name of the database file.
                    "tasks_database"
                ).build()
                // Save the database instance.
                INSTANCE = instance
                instance
            }
        }
    }
}