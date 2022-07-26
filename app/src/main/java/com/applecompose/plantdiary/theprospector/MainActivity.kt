package com.applecompose.plantdiary.theprospector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.applecompose.plantdiary.theprospector.presentation.screens.NoteScreen
import com.applecompose.plantdiary.theprospector.presentation.screens.NoteViewModel
import com.applecompose.plantdiary.theprospector.ui.theme.TheProspectorTheme
import com.google.android.libraries.places.api.Places
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		setContent {
			Places.initialize(this, BuildConfig.GMP_KEY)

			TheProspectorTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					//second way to substantiate view model
					// val noteViewModel = viewModel<NoteViewModel>()
					val noteViewModel: NoteViewModel by viewModels()
					HomeScreen(noteViewModel = noteViewModel)
				}
			}
		}
	}
}

@Composable
fun HomeScreen(noteViewModel: NoteViewModel) {
	val notesList = noteViewModel.noteList.collectAsState().value
	NoteScreen(
		notes = notesList,
		onAddNote = {
			noteViewModel.addNote(it)
		},
		onRemoveNote = {
			noteViewModel.removeNote(it)
		},
		onEditNote = {
			noteViewModel.updateNote(it)
		},

	)
}


