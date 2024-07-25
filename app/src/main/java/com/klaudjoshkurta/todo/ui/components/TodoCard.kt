package com.klaudjoshkurta.todo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.R
import com.klaudjoshkurta.todo.data.Todo
import com.klaudjoshkurta.todo.ui.theme.TodoTheme

@Composable
fun TodoCard(
    modifier: Modifier = Modifier,
    todo: Todo = Todo(title = "Todo item"),
    onClick: (Todo) -> Unit = {},
    onDelete: (Todo) -> Unit = {}
) {

    val icon = if (todo.isCompleted) R.drawable.ic_check_circle else R.drawable.ic_circle
    val textDecoration = if (todo.isCompleted) TextDecoration.LineThrough else TextDecoration.None

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(16.dp),
        onClick = { onClick(todo) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = todo.title,
                style = MaterialTheme.typography.bodyMedium,
                textDecoration = textDecoration,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { onDelete(todo) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_trash),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview(widthDp = 412)
@Composable
fun TodoCardPreview() {
    TodoTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TodoCard(todo = Todo(title = "Todo item ", isCompleted = false))
            TodoCard(todo = Todo(title = "Todo item ", isCompleted = true))
        }
    }
}