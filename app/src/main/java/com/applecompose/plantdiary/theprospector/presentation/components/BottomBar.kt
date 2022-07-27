package com.applecompose.plantdiary.theprospector.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PictureInPicture
import androidx.compose.material.icons.filled.Save
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(
	val icon: ImageVector

) {
	object Save : BottomBar(
		icon = Icons.Default.Save,
	)

	object Picture : BottomBar(
		icon = Icons.Default.PictureInPicture,
	)
}