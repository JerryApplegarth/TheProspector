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
	primary = Primary,
	primaryVariant = PrimaryVariant,
	secondary = Secondary,

	background = NewBackground,
	surface = NewBackground,

	onPrimary = OnPrimaryWhite,
	onSecondary = OnSecondaryWhite,
	onBackground = OnSurfaceBlack,
	onSurface = OnSurfaceBlack,



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