package com.applecompose.plantdiary.theprospector.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)





//Light
val Primary = Color(0xFf00897b)
val Secondary = Color(0xFF4BB6AD)
val OnSurfaceVariant = Color(0xFF52443c)
val OnSurfaceBlack = Color(0xFF201a17)
val OnPrimaryWhite = Color(0xFFffffff)
val OnSecondaryWhite = Color(0xFFffffff)
val PrimaryVariant = Color(0xFF82e9de)
val NewBackground = Color(0xFF7CEBE0)
val CardBackground = Color(0xFFB2E5EF)
val Background = Color(0xFF201a17)

//Dark
val DarkPrimary = Color(0xFF005b4f)
val DarkSecondary = Color(0xff00867d)
val DarkOnSurfaceVariant = Color(0xFFd7c2b8)
val DarkOnSurface = Color(0xFFece0db)
val DarkOnPrimary = Color(0xFFece0db)
val DarkOnSecondary = Color(0xFFece0db)
val DarkPrimaryVariant = Color(0xFF4ebaaa)
val DarkNewBackground = Color(0xff00867d)




val Amber200 = Color(0xFFffe54c)
val Amber500 = Color(0xFFffb300)
val Amber700 = Color(0xFFc68400)
val LightAmber = Color(0xFFffecb3)

val MediumGreen = Color(0xFF3BAE06)



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
