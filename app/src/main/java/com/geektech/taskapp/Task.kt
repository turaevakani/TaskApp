package com.geektech.taskapp
import java.io.Serializable

data class Task(
    private var title: String?,
    private var description: String?
): Serializable
