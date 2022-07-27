package com.applecompose.plantdiary.theprospector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applecompose.plantdiary.theprospector.data.NoteDataDummy
import com.applecompose.plantdiary.theprospector.data.model.Note
import com.applecompose.plantdiary.theprospector.presentation.screens.NoteScreen
import com.applecompose.plantdiary.theprospector.presentation.screens.NoteViewModel
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

					val noteViewModel: NoteViewModel by viewModels()
					HomeScreen(noteViewModel = noteViewModel)
				}
			}
		}
	}
}

@Composable
fun HomeScreen(noteViewModel: NoteViewModel = viewModel()) {
	val notesList = noteViewModel.getAllNotes()
	NoteScreen(
		notes = notesList,
		onAddNote = {
			noteViewModel.addNote(it)

		},
		onRemoveNote = {
			noteViewModel.removeNote(it)

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