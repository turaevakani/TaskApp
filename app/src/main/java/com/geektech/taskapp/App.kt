package com.geektech.taskapp

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geektech.taskapp.data.AppDatabase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }

    companion object{
        lateinit var db:AppDatabase
    }
}