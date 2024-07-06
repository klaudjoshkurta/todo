package com.klaudjoshkurta.todo.ui.home.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.R
import com.klaudjoshkurta.todo.ui.theme.TodoTheme

@Composable
fun TodoInputBar(
    modifier: Modifier = Modifier,
    onTodoAdded: (String) -> Unit = {}
) {
    val input = remember { mutableStateOf("") }

    Card(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(200.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = CardDefaults.outlinedCardBorder(
            enabled = true
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = input.value,
                onValueChange = { input.value = it },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                decorationBox = { innerTextField ->
                    if (input.value.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.input_bar_hint),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    innerTextField()
                }
            )
            FilledIconButton(
                onClick = {
                    if (input.value.isNotEmpty()) {
                        onTodoAdded(input.value)
                        input.value = ""
                    }
                },
                modifier = Modifier.padding(end = 8.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(widthDp = 412, showBackground = true)
@Composable
fun TodoInputBarPreview() {
    TodoTheme {
        TodoInputBar()
    }
}