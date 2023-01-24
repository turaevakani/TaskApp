package com.geektech.taskapp.model
import java.io.Serializable

data class Task(
    var title: String?,
    var description: String?
): Serializable
