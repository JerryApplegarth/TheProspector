package com.applecompose.plantdiary.theprospector.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)



//Light
val Primary = Color(0xfffb8c00)
val Secondary = Color(0xFfffbd45)
val OnSurfaceVariant = Color(0xFFc25e00)
val OnSurface = Color(0xFF201a17)
val OnPrimary = Color(0xFF201a17)
val OnSecondary = Color(0xFF201a17)
val PrimaryVariant = Color(0xFFF8A337)
val NewBackground = Color(0xFFF9CD96)
val CardBackground = Color(0xFFF8A337)

//Dark
val DarkPrimary = Color(0xffef6c00)
val DarkSecondary = Color(0xFFb53d00)
val DarkOnSurfaceVariant = Color(0xFFd7c2b8)
val DarkOnSurface = Color(0xFFece0db)
val DarkOnPrimary = Color(0xFFece0db)
val DarkOnSecondary = Color(0xFFece0db)
val DarkPrimaryVariant = Color(0xFFff9d3f)
val DarkNewBackground = Color(0xffc25e00)




val Amber200 = Color(0xFFffe54c)
val Amber500 = Color(0xFFffb300)
val Amber700 = Color(0xFFc68400)
val LightAmber = Color(0xFFffecb3)

val MediumGreen = Color(0xFF3BAE06)
val DarkGreen = Color(0xFF2E8805)



val Tan = Color(0xFFDDBC83)

val Colors.cardBackground: Color
    @Composable
    get() = if (isLight) CardBackground else MediumGreen

val Colors.mediumGreen: Color
    @Composable
    get() = if (isLight) MediumGreen else MediumGreen


val Colors.newBackgroundColor: Color
    @Composable
    get() = if (isLight) NewBackground else DarkNewBackground

val Colors.fontColor: Color
    @Composable
    get() = if (isLight) DarkOnSecondary else DarkOnPrimary

val Colors.iconColor: Color
    @Composable
    get() = if (isLight) DarkGreen else DarkGreen
