package com.heimdall.whattodo.ui.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.heimdall.whattodo.domain.Task
import com.heimdall.whattodo.domain.tasksMock
import com.heimdall.whattodo.ui.components.TaskItem
import com.heimdall.whattodo.ui.theme.WhatTodoTheme

@Composable
fun ListScreen(
    navToAddEditScreen: (id: Long?) -> Unit
) {
    ListContent(tasks = tasksMock, navToAddEditScreen)
}

@Composable
fun ListContent(
    tasks: List<Task>,
    onAddItemClick: (id: Long?) -> Unit
) {
    Scaffold (
         floatingActionButton = {
             FloatingActionButton(onClick = { onAddItemClick(null) }) {
                 Icon(Icons.Default.Add, contentDescription = "Add")
             }
         }
    ) { paddingValues ->
        LazyColumn (
            modifier = Modifier
                .consumeWindowInsets(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks) { task ->
                TaskItem(
                    task = task,
                    onCompletedChange = {},
                    onItemClick = { onAddItemClick(task.id) },
                    onDeleteClick = {})
            }
        }
    }
}

@Preview
@Composable
private fun ListContentPreview() {
    WhatTodoTheme {
        ListContent(tasks = tasksMock) {}
    }
}