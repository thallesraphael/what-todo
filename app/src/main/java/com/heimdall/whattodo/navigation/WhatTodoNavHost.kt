package com.heimdall.whattodo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.heimdall.whattodo.ui.feature.addedit.AddEditTaskScreen
import com.heimdall.whattodo.ui.feature.ListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListRoute

@Serializable
data class AddEditRoute(val id: Long? = null)


@Composable
fun WhatTodoNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ListRoute) {
        composable<ListRoute> {
            ListScreen { id ->
                navController.navigate(AddEditRoute(id))
            }
        }

        composable<AddEditRoute> {
            val addEditRoute = it.toRoute<AddEditRoute>()

            AddEditTaskScreen()
        }
    }
    
}