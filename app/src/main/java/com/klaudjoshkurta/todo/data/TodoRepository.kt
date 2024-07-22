package com.klaudjoshkurta.todo.data

import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {

    val allTodos: Flow<List<TodoItem>> = todoDao.getAllTodos()

    suspend fun insert(todoItem: TodoItem) {
        todoDao.insert(todoItem)
    }

    suspend fun delete(todoItem: TodoItem) {
        todoDao.delete(todoItem)
    }
}