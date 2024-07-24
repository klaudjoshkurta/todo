package com.klaudjoshkurta.todo.ui.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.R
import com.klaudjoshkurta.todo.data.model.Todo
import com.klaudjoshkurta.todo.ui.theme.TodoTheme

@Composable
fun TodoItem(
    modifier: Modifier = Modifier,
    todo: Todo = Todo(title = "Todo item"),
    isDone: Boolean = false,
) {

    val icon = if (isDone) R.drawable.ic_check_circle else R.drawable.ic_circle
    val textDecoration = if (isDone) TextDecoration.LineThrough else TextDecoration.None

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = null)
            Text(text = todo.title, textDecoration = textDecoration)
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