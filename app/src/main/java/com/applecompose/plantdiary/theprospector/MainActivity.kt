package com.applecompose.plantdiary.theprospector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.applecompose.plantdiary.theprospector.data.NoteDataDummy
import com.applecompose.plantdiary.theprospector.data.model.Note
import com.applecompose.plantdiary.theprospector.presentation.screens.NoteScreen
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
	val notes = remember { mutableStateListOf<Note>() }
	NoteScreen(
		notes = notes,
		onAddNote = {
					notes.add(it)

		},
		onRemoveNote = {
			notes.remove(it)
		}
	)


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