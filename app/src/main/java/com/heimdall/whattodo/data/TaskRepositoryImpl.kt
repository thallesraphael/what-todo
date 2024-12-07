package com.heimdall.whattodo.data

import com.heimdall.whattodo.domain.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl (
    val taskDao: TaskDao
) : TaskRepository {
    override suspend fun insert(title: String, description: String?) {
        val entity = TaskEntity(
            title = title,
            description = description,
            isCompleted = false,
        )

        taskDao.insert(entity)
    }

    override suspend fun updateCompleted(id: Long, isCompleted: Boolean) {
        val existingEntity = taskDao.getBy(id) ?: return
        val updated = existingEntity.copy(isCompleted = isCompleted)
        taskDao.insert(updated)
    }

    override suspend fun delete(id: Long) {
        val existingEntity = taskDao.getBy(id) ?: return
        taskDao.delete(existingEntity)
    }

    override fun getAll(): Flow<List<Task>> {
        return taskDao.getAll().map { entities ->
            entities.map { it.toTask() }
        }
    }

    override suspend fun getBy(id: Long): Task? {
        return taskDao.getBy(id)?.toTask()
    }
}