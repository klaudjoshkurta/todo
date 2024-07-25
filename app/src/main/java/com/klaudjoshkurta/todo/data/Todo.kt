package com.klaudjoshkurta.todo.data

import java.util.UUID

data class Todo(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    var isCompleted: Boolean = false
)