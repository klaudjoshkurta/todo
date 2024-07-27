@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.klaudjoshkurta.todo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.klaudjoshkurta.todo.ui.theme.TodoTheme
import com.klaudjoshkurta.todo.ui.theme.geistMonoFamily

@Composable
fun EntryScreen(
    onCancel: () -> Unit = {},
) {
    Scaffold(
        topBar = { EntryTopBar() },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current
        val keyboardController = LocalSoftwareKeyboardController.current

        var value by remember { mutableStateOf("") }

        DisposableEffect(Unit) {
            /** Request focus on the TextField using the FocusRequester instance */
            focusRequester.requestFocus()
            /** Show the software keyboard using the KeyboardController instance */
            keyboardController?.show()
            /** Define the cleanup logic to run when the DisposableEffect leaves the Composition */
            onDispose {
                /** Hide the software keyboard when the Composable leaves the composition */
                keyboardController?.hide()
                /** Clear the focus when the Composable leaves the composition */
                focusManager.clearFocus()
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EntryInput(
                    value = value,
                    onValueChange = { value = it },
                    modifier = Modifier.fillMaxWidth().focusRequester(focusRequester)
                )
            }
            EntryActions(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
                    .imePadding(),
                onCancel = {
                    onCancel()
                    keyboardController?.hide()
                },
                onSave = {}
            )
        }
    }
}

// region Composable functions
@Composable
private fun EntryTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        modifier = modifier
    )
}

@Composable
private fun EntryInput(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {}
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            fontFamily = geistMonoFamily,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        ),
        decorationBox = { innerTextField ->
            if (value.isEmpty()) {
                Text(
                    text = "Enter a todo item",
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
            innerTextField()
        },
        modifier = modifier
    )
}

@Composable
private fun EntryActions(
    modifier: Modifier = Modifier,
    onCancel: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onCancel,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Text(text = "Cancel")
        }
        Button(
            onClick = onSave
        ) {
            Text(text = "Save")
        }
    }
}
// endregion

// region Functions

// endregion

// region Previews
@Preview(showSystemUi = true)
@Composable
fun EntryScreenPreview() {
    TodoTheme {
        EntryScreen()
    }
}
// endregion