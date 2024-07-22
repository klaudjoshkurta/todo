package com.klaudjoshkurta.todo.ui.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.klaudjoshkurta.todo.R
import com.klaudjoshkurta.todo.data.TodoItem
import com.klaudjoshkurta.todo.ui.theme.LargeDp
import com.klaudjoshkurta.todo.ui.theme.MediumDp
import com.klaudjoshkurta.todo.ui.theme.TodoItemActionButtonRippleRadius
import com.klaudjoshkurta.todo.ui.theme.TodoItemBackgroundColor
import com.klaudjoshkurta.todo.ui.theme.TodoItemHeight
import com.klaudjoshkurta.todo.ui.theme.TodoItemIconColor
import com.klaudjoshkurta.todo.ui.theme.TodoItemIconSize
import com.klaudjoshkurta.todo.ui.theme.TodoItemTextColor
import com.klaudjoshkurta.todo.ui.theme.TodoItemTitleTextStyle

@Composable
fun TodoItemUi(
    todoItem: TodoItem = TodoItem(title = "Todo Item"),
    onItemClick: (TodoItem) -> Unit = {},
    onItemDelete: (TodoItem) -> Unit = {},
) {

    val backgroundColor = if (todoItem.isDone) TodoItemBackgroundColor.copy(alpha = 0.5f) else TodoItemBackgroundColor
    val textColor = if (todoItem.isDone) TodoItemTextColor.copy(alpha = 0.5f) else TodoItemTextColor

    val textDecoration = if (todoItem.isDone) TextDecoration.LineThrough else null

    val iconId = if (todoItem.isDone) R.drawable.checkbox else R.drawable.checkbox_empty
    val iconTintColor = if (todoItem.isDone) TodoItemIconColor.copy(alpha = 0.5f) else TodoItemIconColor

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(TodoItemHeight),
        elevation = CardDefaults.cardElevation(defaultElevation = LargeDp),
        shape = RoundedCornerShape(MediumDp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = true),
                    onClick = { onItemClick(todoItem) },
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier
                    .padding(MediumDp)
                    .size(TodoItemIconSize),
                tint = iconTintColor,
            )
            Text(
                text = todoItem.title,
                modifier = Modifier.weight(1f),
                style = TodoItemTitleTextStyle.copy(color = textColor),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textDecoration = textDecoration,
            )
            IconButton(
                onClick = { onItemDelete(todoItem) },
                modifier = Modifier.size(TodoItemActionButtonRippleRadius)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = null,
                    modifier = Modifier.size(TodoItemIconSize),
                    tint = TodoItemIconColor
                )
            }
        }
    }
}

@Preview
@Composable
fun TodoItemUiPreview() {
    Column(
        modifier = Modifier.padding(MediumDp),
        verticalArrangement = Arrangement.spacedBy(MediumDp)
    ) {
        TodoItemUi(todoItem = TodoItem(title = "Todo Item 1"))
        TodoItemUi(todoItem = TodoItem(title = "Todo Item 2", isDone = true))
        TodoItemUi(todoItem = TodoItem(title = "Todo Item 3"))
        TodoItemUi(todoItem = TodoItem(title = "Todo Item 4", isDone = true))
    }
}
