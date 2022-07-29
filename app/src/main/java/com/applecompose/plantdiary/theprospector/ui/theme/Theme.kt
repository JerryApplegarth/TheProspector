package com.applecompose.plantdiary.theprospector.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
	primary = DarkPrimary,
	primaryVariant = DarkPrimaryVariant,
	secondary = DarkSecondary,
	onPrimary = DarkOnPrimary,
	onSecondary = DarkOnSecondary,
	onSurface = DarkOnSurface,
)

private val LightColorPalette = lightColors(
	primary = MyPurple,
	primaryVariant = PrimaryVariant,
	secondary = MediumGrey,

	background = Background2,
	surface = Background2,

	onPrimary = Black2,
	onSecondary = Black2,
	onBackground = Black2,
	onSurface = Black2,



	/* Other default colors to override



    */
)


	/* Other default colors to override
    background = Color.White,

    */




@Composable
fun TheProspectorTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	content: @Composable () -> Unit
) {
	val colors = if (darkTheme) {
		DarkColorPalette
	} else {
		LightColorPalette
	}

	MaterialTheme(
		colors = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}