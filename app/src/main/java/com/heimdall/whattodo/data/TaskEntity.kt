package com.heimdall.whattodo.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.heimdall.whattodo.domain.Task

@Entity(tableName = "Task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String?,
    val isCompleted: Boolean
)

fun TaskEntity.toTask() = Task (
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted
)
