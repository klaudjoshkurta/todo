@file:OptIn(ExperimentalMaterial3Api::class)

package com.klaudjoshkurta.todo.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.klaudjoshkurta.todo.ui.theme.TodoTheme
import com.klaudjoshkurta.todo.util.userGreeting
import kotlinx.coroutines.delay
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { HomeTopBar() },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /** Greeting message */
            GreetingMessage(
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
fun HomeTopBar() {
    TopAppBar(
        title = { },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun GreetingMessage(
    modifier: Modifier = Modifier,
    name: String = "Klaudjo"
) {
    /** Get current time */
    var currentTime by remember { mutableStateOf(LocalTime.now()) }

    /** Update the time periodically */
    LaunchedEffect(Unit) {
        while (true) {
            delay(60000) // Update every minute
            currentTime = LocalTime.now()
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = userGreeting(name, currentTime),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    TodoTheme {
        HomeScreen()
    }
}