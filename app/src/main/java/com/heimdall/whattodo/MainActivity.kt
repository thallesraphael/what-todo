package com.heimdall.whattodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import com.heimdall.whattodo.navigation.WhatTodoNavHost
import com.heimdall.whattodo.ui.theme.WhatTodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier
                .safeDrawingPadding()
            ) {
                WhatTodoTheme {
                    WhatTodoNavHost()
                }
            }
        }
    }
}