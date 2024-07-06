package com.klaudjoshkurta.todo.ui.home.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.klaudjoshkurta.todo.R
import com.klaudjoshkurta.todo.model.TodoItem
import com.klaudjoshkurta.todo.ui.theme.TodoTheme

@Composable
fun TodoItem(
    todoItem: TodoItem = TodoItem(title = "Sample todo item"),
    onItemClicked: (TodoItem) -> Unit = {},
    onItemDeleted: (TodoItem) -> Unit = {}
) {
    val textColor = if (todoItem.completed) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurface
    val textDecoration = if (todoItem.completed) TextDecoration.LineThrough else TextDecoration.None
    val icon = if (todoItem.completed) R.drawable.checkbox else R.drawable.checkbox_empty

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = true),
                    onClick = { onItemClicked(todoItem) }
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = todoItem.title,
                textDecoration = textDecoration,
                lineHeight = 20.sp,
                color = textColor,
                modifier = Modifier.weight(1f),
            )
            IconButton(
                onClick = { onItemDeleted(todoItem) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        HorizontalDivider()
    }
}

@Preview(widthDp = 412, showBackground = true)
@Composable
fun TodoItemPreview() {
    TodoTheme {
        Column {
            TodoItem(todoItem = TodoItem(title = "Sample todo item", completed = false))
            TodoItem(todoItem = TodoItem(title = "Sample todo item", completed = true))
        }
    }
}