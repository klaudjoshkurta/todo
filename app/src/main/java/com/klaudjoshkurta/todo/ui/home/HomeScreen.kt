package com.klaudjoshkurta.todo.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.klaudjoshkurta.todo.data.AppDatabase
import com.klaudjoshkurta.todo.data.TodoDao
import com.klaudjoshkurta.todo.data.TodoItem
import com.klaudjoshkurta.todo.data.TodoRepository
import com.klaudjoshkurta.todo.ui.home.composables.TodoInputBar
import com.klaudjoshkurta.todo.ui.home.composables.TodoItemsContainer
import com.klaudjoshkurta.todo.ui.theme.OverlappingHeight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreen(
    todoDao: TodoDao
) {

    val homeViewModel = HomeViewModel(TodoRepository(todoDao), ioDispatcher = Dispatchers.IO)

    Box(
        modifier = Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding()
    ) {
        TodoItemsContainer(
            // 1. Mock Data for Todo Items
            todoItemsFlow = homeViewModel.todos,
            onItemClick = homeViewModel::toggleTodo,
            onItemDelete = homeViewModel::removeTodo,
            // 2. Space Adjustment for Overlapping UI Elements
            overlappingElementsHeight = OverlappingHeight
        )
        TodoInputBar(
            modifier = Modifier.align(Alignment.BottomStart).imePadding(),
            onAddButtonClick = homeViewModel::addTodo
        )
    }
}