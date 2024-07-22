package com.klaudjoshkurta.todo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klaudjoshkurta.todo.data.TodoItem
import com.klaudjoshkurta.todo.data.TodoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class HomeViewModel(
    // 1. ViewModel Initialization
    private val repository: TodoRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    // 2. Todo Data Flow
    val todos = repository.allTodos

    // 3. Todo Operations
    fun addTodo(todo: String) =
        viewModelScope.launch(ioDispatcher) { repository.insert(TodoItem(title = todo)) }

    fun toggleTodo(todoItem: TodoItem) =
        viewModelScope.launch(ioDispatcher) { repository.insert(todoItem.copy(isDone = !todoItem.isDone)) }

    fun removeTodo(todoItem: TodoItem) =
        viewModelScope.launch(ioDispatcher) { repository.delete(todoItem) }
}