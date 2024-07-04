package com.klaudjoshkurta.todo.model

import java.util.UUID

data class TodoItem(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val completed: Boolean = false
)
