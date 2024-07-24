package com.klaudjoshkurta.todo.data.model

import java.util.UUID

data class Todo(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    var isDone: Boolean = false
)