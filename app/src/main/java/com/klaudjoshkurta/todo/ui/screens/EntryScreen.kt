@file:OptIn(ExperimentalMaterial3Api::class)

package com.klaudjoshkurta.todo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.ui.theme.TodoTheme

@Composable
fun EntryScreen(
    onCancel: () -> Unit = {},
) {
    Scaffold(
        topBar = { EntryTopBar() },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            EntryActions(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onCancel = onCancel,
                onSave = {}
            )
        }
    }
}

@Composable
fun EntryTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        modifier = modifier
    )
}

@Composable
fun EntryActions(
    modifier: Modifier = Modifier,
    onCancel: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onCancel,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Text(text = "Cancel")
        }
        Button(
            onClick = onSave
        ) {
            Text(text = "Save")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun EntryScreenPreview() {
    TodoTheme {
        EntryScreen()
    }
}