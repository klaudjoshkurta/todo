@file:OptIn(ExperimentalMaterial3Api::class)

package com.klaudjoshkurta.todo.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.data.model.Todo
import com.klaudjoshkurta.todo.ui.home.composables.TodoList
import com.klaudjoshkurta.todo.ui.theme.TodoTheme
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(200.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(bottom = 60.dp)
                    .size(70.dp)
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        val todos = listOf(
            Todo(title = "Todo Item 1"),
            Todo(title = "Todo Item 2", isDone = true),
            Todo(title = "Todo Item 3"),
            Todo(title = "Todo Item 4", isDone = true),
            Todo(title = "Todo Item 5"),
            Todo(title = "Todo Item 6"),
            Todo(title = "Todo Item 7"),
            Todo(title = "Todo Item 8"),
            Todo(title = "Todo Item 9"),
            Todo(title = "Todo Item 10"),
            Todo(title = "Todo Item 11", isDone = true),
            Todo(title = "Todo Item 12"),
            Todo(title = "Todo Item 13"),
            Todo(title = "Todo Item 14"),
            Todo(title = "Todo Item 15")
        )

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Good morning, Klaudjo",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = if (todos.any { it.isDone }) "You have ${todos.count { !it.isDone }} tasks left" else "You have ${todos.count()} tasks",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
            }
            TodoList(
                todoItemsFlow = flowOf(todos),
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    TodoTheme {
        HomeScreen()
    }
}