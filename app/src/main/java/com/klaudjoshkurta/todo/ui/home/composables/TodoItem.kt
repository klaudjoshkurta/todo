package com.klaudjoshkurta.todo.ui.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.R
import com.klaudjoshkurta.todo.model.TodoItem
import com.klaudjoshkurta.todo.ui.theme.TodoTheme

@Composable
fun TodoItem(
    todoItem: TodoItem = TodoItem(title = "Sample todo item"),
    onItemClicked: (TodoItem) -> Unit = {},
    onItemDeleted: (TodoItem) -> Unit = {}
) {
    val textDecoration = if (todoItem.completed) TextDecoration.LineThrough else TextDecoration.None

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = todoItem.title, textDecoration = textDecoration)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                onClick = { onItemClicked(todoItem) }
            ) {
                Text(text = "Mark as completed")
            }
            IconButton(
                onClick = { onItemDeleted(todoItem) }
            ) {
                Icon(imageVector = Icons.Outlined.Delete, contentDescription = stringResource(R.string.delete_button_cd))
            }
        }
    }
}

@Preview(widthDp = 412, showBackground = true)
@Composable
fun TodoItemPreview() {
    TodoTheme {
        TodoItem()
    }
}