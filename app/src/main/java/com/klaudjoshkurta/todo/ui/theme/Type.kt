package com.klaudjoshkurta.todo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.klaudjoshkurta.todo.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Azeret Mono")

val fontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = fontFamily,
    ),
    displayMedium = TextStyle(
        fontFamily = fontFamily,
    ),
    displaySmall = TextStyle(
        fontFamily = fontFamily,
    ),
    headlineLarge = TextStyle(
        fontFamily = fontFamily,
    ),
    headlineMedium = TextStyle(
        fontFamily = fontFamily,
    ),
    headlineSmall = TextStyle(
        fontFamily = fontFamily,
    ),
    titleLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fontFamily,
    ),
    titleSmall = TextStyle(
        fontFamily = fontFamily,
    ),
    bodyLarge = TextStyle(
        fontFamily = fontFamily,
    ),
    bodyMedium = TextStyle(
        fontFamily = fontFamily,
    ),
    bodySmall = TextStyle(
        fontFamily = fontFamily,
    ),
    labelLarge = TextStyle(
        fontFamily = fontFamily,
    ),
    labelMedium = TextStyle(
        fontFamily = fontFamily,
    ),
    labelSmall = TextStyle(
        fontFamily = fontFamily,
    )
)