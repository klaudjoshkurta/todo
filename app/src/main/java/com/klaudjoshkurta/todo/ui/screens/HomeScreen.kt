@file:OptIn(ExperimentalMaterial3Api::class)

package com.klaudjoshkurta.todo.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.R
import com.klaudjoshkurta.todo.data.Todo
import com.klaudjoshkurta.todo.data.todoList
import com.klaudjoshkurta.todo.ui.components.TodoCard
import com.klaudjoshkurta.todo.ui.theme.TodoTheme
import com.klaudjoshkurta.todo.util.userGreeting
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navigateToEntryScreen: () -> Unit = {}
) {
    Scaffold(
        topBar = { HomeTopBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToEntryScreen,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(200.dp),
                modifier = Modifier.size(70.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /** Greeting message */
            GreetingMessage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 60.dp),
                todosCount = 3
            )
            /** Todos list */
            TodoItems(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                todoItems = todoList,
                onItemClick = { /* TODO: Handle item click */ },
                onItemDelete = { /* TODO: Handle item delete */ }
            )
        }
    }
}

@Composable
fun HomeTopBar() {
    TopAppBar(
        title = { },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun GreetingMessage(
    modifier: Modifier = Modifier,
    name: String = "Klaudjo",
    todosCount: Int = 3
) {
    /** Get current time */
    var currentTime by remember { mutableStateOf(LocalTime.now()) }

    /** Update the time periodically */
    LaunchedEffect(Unit) {
        while (true) {
            delay(60000) // Update every minute
            currentTime = LocalTime.now()
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = userGreeting(name, currentTime),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "You have $todosCount todos left for today.",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun TodoItems(
    modifier: Modifier = Modifier,
    todoItems: Flow<List<Todo>> = flowOf(listOf()),
    onItemClick: (Todo) -> Unit = {},
    onItemDelete: (Todo) -> Unit = {},
    overlappingElementsHeight: Dp = 0.dp
) {
    /** Flow data collection */
    val todos = todoItems.collectAsState(initial = listOf()).value

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(todos, key = { it.id }) { todo ->
            TodoCard(
                todo = todo,
                onClick = onItemClick,
                onDelete = onItemDelete
            )
        }

        /** Use this item for layout adjustment */
        item {
            Spacer(modifier = Modifier.height(overlappingElementsHeight))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    TodoTheme {
        HomeScreen()
    }
}