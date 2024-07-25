package com.klaudjoshkurta.todo.data

import kotlinx.coroutines.flow.flowOf
import java.util.UUID

data class Todo(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    var isCompleted: Boolean = false
)

/** Mock data */
val todoList = flowOf(
    listOf(
        Todo(title = "Pick up dry cleaning", isCompleted = false),
        Todo(title = "Buy groceries for the week", isCompleted = false),
        Todo(title = "Submit project proposal to client", isCompleted = true),
        Todo(title = "Water plants", isCompleted = true),
        Todo(title = "Call mom for her birthday", isCompleted = false),
    )
)