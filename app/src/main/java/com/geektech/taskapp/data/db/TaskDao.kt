package com.geektech.taskapp.data.db

import androidx.room.*
import com.geektech.taskapp.model.Task

@Dao
interface TaskDao {


        @Query("SELECT * FROM task")
        fun getAll(): List<Task>

        @Insert
        fun insertAll(task: Task)

        @Delete
        fun delete(task: Task)

        @Update
        fun update(task: Task)

}