package com.heimdall.whattodo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AdvancedTaskItem(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        shadowElevation = 2.dp,
        border = BorderStroke(
            width = 1.dp,
            MaterialTheme.colorScheme.outline
        )
    ) {

        Row {
            RadioButton(selected = false, onClick = { /*TODO*/ })
        }
    }
}


@Preview
@Composable
private fun AdvancedTaskItemPreview() {
    AdvancedTaskItem()
}