package com.klaudjoshkurta.todo.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.model.TodoItem
import com.klaudjoshkurta.todo.ui.home.composables.TodoInputBar
import com.klaudjoshkurta.todo.ui.home.composables.TodoItem
import com.klaudjoshkurta.todo.ui.theme.TodoTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            TodoInputBar(
                modifier = Modifier
                    .imePadding(),
                onTodoAdded = {}
            )
        },
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            TodoList(
                todoItemsFlow = flowOf(
                    listOf(
                        TodoItem(title = "Sample todo item", completed = false),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = false),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = false),
                        TodoItem(title = "Sample todo item", completed = false),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                        TodoItem(title = "Sample todo item", completed = true),
                    )
                ),
                onItemClicked = {},
                onItemDeleted = {},
                overlappingElementsHeight = 92.dp
            )
        }
    }
}

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
    todoItemsFlow: Flow<List<TodoItem>> = flowOf(emptyList()),
    onItemClicked: (TodoItem) -> Unit = {},
    onItemDeleted: (TodoItem) -> Unit = {},
    overlappingElementsHeight: Dp = 0.dp
) {
    val todos = todoItemsFlow.collectAsState(initial = listOf()).value

    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(todos, key = { it.id }) { item ->
            TodoItem(
                todoItem = item,
                onItemClicked = onItemClicked,
                onItemDeleted = onItemDeleted,
            )
        }
        if (overlappingElementsHeight > 0.dp) {
            item {
                Spacer(modifier = Modifier.height(overlappingElementsHeight))
            }
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