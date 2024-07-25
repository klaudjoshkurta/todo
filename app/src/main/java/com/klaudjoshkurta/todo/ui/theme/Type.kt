package com.klaudjoshkurta.todo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.klaudjoshkurta.todo.R

val geistMonoFamily = FontFamily(
    Font(resId = R.font.geist_mono_thin, weight = FontWeight.Thin),
    Font(resId = R.font.geist_mono_ultralight, weight = FontWeight.ExtraLight),
    Font(resId = R.font.geist_mono_light, weight = FontWeight.Light),
    Font(resId = R.font.geist_mono_regular, weight = FontWeight.Normal),
    Font(resId = R.font.geist_mono_medium, weight = FontWeight.Medium),
    Font(resId = R.font.geist_mono_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.geist_mono_bold, weight = FontWeight.Bold),
    Font(resId = R.font.geist_mono_black, weight = FontWeight.Black),
    Font(resId = R.font.geist_mono_ultrablack, weight = FontWeight.ExtraBold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = geistMonoFamily,
        fontSize = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = geistMonoFamily,
    ),
    titleSmall = TextStyle(
        fontFamily = geistMonoFamily,
    ),
    bodyLarge = TextStyle(
        fontFamily = geistMonoFamily,
    ),
    bodyMedium = TextStyle(
        fontFamily = geistMonoFamily,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = geistMonoFamily,
    ),
    labelLarge = TextStyle(
        fontFamily = geistMonoFamily,
    ),
    labelMedium = TextStyle(
        fontFamily = geistMonoFamily,
    ),
    labelSmall = TextStyle(
        fontFamily = geistMonoFamily,
    )
)