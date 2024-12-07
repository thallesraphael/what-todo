package com.heimdall.whattodo.domain

import com.heimdall.whattodo.data.TaskEntity

data class Task(
    val id: Long,
    val title: String,
    val description: String?,
    val isCompleted: Boolean
)

// Mock
val task1 = Task(
    id = 1,
    title = "Task 1",
    description = "Task 1 description",
    isCompleted = false
)

val task2 = Task(
    id = 2,
    title = "Task 2",
    description = "Task 2 description",
    isCompleted = true
)
val task3 = Task(
    id = 3,
    title = "Task 3",
    description = "Task 3 description",
    isCompleted = false
)

val tasksMock = listOf(task1, task2, task3)