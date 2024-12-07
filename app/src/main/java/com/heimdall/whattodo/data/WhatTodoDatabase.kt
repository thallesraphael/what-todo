package com.heimdall.whattodo.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TaskEntity::class],
    version = 1
)
abstract class WhatTodoDatabase : RoomDatabase() {

    abstract val taskDao: TaskDao
}