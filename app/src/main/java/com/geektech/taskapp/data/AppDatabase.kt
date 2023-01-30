package com.geektech.taskapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.taskapp.data.db.TaskDao
import com.geektech.taskapp.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}