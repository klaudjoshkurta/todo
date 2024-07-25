package com.klaudjoshkurta.todo.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
fun userGreeting(name: String, currentTime: LocalTime): String {
    val hour = currentTime.hour
    return when (hour) {
        in 0..11 -> "Good morning, $name!"
        in 12..17 -> "Good afternoon, $name!"
        else -> "Good evening, $name!"
    }
}