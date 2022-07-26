package com.applecompose.plantdiary.theprospector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applecompose.plantdiary.theprospector.presentation.components.HomeTitle
import com.applecompose.plantdiary.theprospector.ui.theme.TheProspectorTheme
import com.applecompose.plantdiary.theprospector.ui.theme.newBackgroundColor

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TheProspectorTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.newBackgroundColor
				) {
					HomeScreen()
				}
			}
		}
	}
}

@Composable
fun HomeScreen() {
	HomeTitle()



	}





















@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	TheProspectorTheme {
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colors.newBackgroundColor
		) {
			HomeScreen()

		}

	}
}