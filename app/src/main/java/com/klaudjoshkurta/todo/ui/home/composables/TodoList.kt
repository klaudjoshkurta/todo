package com.klaudjoshkurta.todo.ui.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.data.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
    todoItemsFlow: Flow<List<Todo>> = flowOf(listOf())
) {

    val todos = todoItemsFlow.collectAsState(initial = listOf()).value

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(todos, key = { it.id }) { item ->
            TodoItem(
                todo = item,
            )
        }
    }
}