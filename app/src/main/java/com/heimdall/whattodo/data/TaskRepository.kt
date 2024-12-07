package com.heimdall.whattodo.data

import com.heimdall.whattodo.domain.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insert(title: String, description: String?)

    suspend fun updateCompleted(id: Long, isCompleted: Boolean)

    suspend fun delete(id: Long)

    fun getAll(): Flow<List<Task>>

    suspend fun getBy(id: Long): Task?
}