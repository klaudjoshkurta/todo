package com.klaudjoshkurta.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.klaudjoshkurta.todo.data.AppDatabase
import com.klaudjoshkurta.todo.ui.home.HomeScreen
import com.klaudjoshkurta.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                val db = Room
                    .databaseBuilder(applicationContext, AppDatabase::class.java, "todo-db")
                    .build()
                HomeScreen(db.todoDao())
            }
        }
    }
}