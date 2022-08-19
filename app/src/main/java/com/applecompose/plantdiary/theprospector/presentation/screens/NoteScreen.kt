package com.applecompose.plantdiary.theprospector.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PictureInPicture
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applecompose.plantdiary.theprospector.R
import com.applecompose.plantdiary.theprospector.data.NoteDataDummy
import com.applecompose.plantdiary.theprospector.data.model.Note
import com.applecompose.plantdiary.theprospector.presentation.components.NoteInputText
import com.applecompose.plantdiary.theprospector.presentation.components.NoteRow
import com.applecompose.plantdiary.theprospector.ui.theme.TheProspectorTheme

@Composable
fun NoteScreen(
	notes: List<Note>,
	onAddNote: (Note) -> Unit,
	onRemoveNote: (Note) -> Unit,
	onEditNote: (Note) -> Unit

) {
	var title by remember { mutableStateOf("") }
	var description by remember { mutableStateOf("") }
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
			.background(MaterialTheme.colors.background),
		horizontalAlignment = Alignment.Start,
		verticalArrangement = Arrangement.Top
	) {
		TopAppBar(
			title = {
				Text(text = stringResource(id = R.string.app_name))
			},
			backgroundColor = MaterialTheme.colors.primary
		)

		Divider(
			color = MaterialTheme.colors.primary,
			thickness = 2.dp
		)
		Spacer(modifier = Modifier.height(6.dp))
		Text(text = "New Prospect: ")
		Spacer(modifier = Modifier.height(12.dp))
		Row(
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				painter = painterResource(id = R.drawable.ic_baseline_my_location_24),
				contentDescription = "Location icon",
				modifier = Modifier
					.clickable {

					}
			)
			Column(
				modifier = Modifier
					.padding(12.dp)
			) {
				Text(text = "Latitude: ")
				Text(text = "Longitude: ")

			}

		}
		//input text goes here
		Divider(
			color = MaterialTheme.colors.primary,
			thickness = 2.dp
		)
		NoteInputText(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 6.dp)
				.padding(6.dp),
			text = title,
			label = "Title of Prospect",
			onTextChange = {
				title = it
			}
		)
		NoteInputText(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 6.dp, bottom = 6.dp)
				.padding(6.dp),
			text = description,
			label = "Describe the Prospect",
			onTextChange = {
				description = it
			}
		)
		// my cards goes here a lazy column
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(6.dp)
				.padding(16.dp, end = 16.dp),
			horizontalArrangement = Arrangement.SpaceBetween
		) {

			Icon(
				imageVector = Icons.Default.Save,
				contentDescription = "Save icon",
				modifier = Modifier
					.clickable {
						if (title.isNotEmpty() && description.isNotEmpty()) {
							onAddNote(
								Note(
									title = title,
									description = description
								)
							)
							title = ""
							description = ""
							Toast.makeText(
								context, "Your prospect was added",
								Toast.LENGTH_SHORT
							).show()
						}
					}
			)
			Text(
				text = "Add a picture ",
				modifier = Modifier
					.padding(end = 48.dp)
					.width(200.dp),
				textAlign = TextAlign.End
			)
			Icon(
				imageVector = Icons.Default.PictureInPicture,
				contentDescription = "Add Picture",
				modifier = Modifier
					.clickable {

					}
			)

		}
		Divider(color = MaterialTheme.colors.primary, thickness = 2.dp)
		Spacer(modifier = Modifier.height(6.dp))
		LazyColumn {
			items(notes) { note ->
				NoteRow(
					note = note,
					onNoteClicked = {
						onRemoveNote(note)
					},
					onEditNoteClicked = {
						onEditNote(note)


					}

				)


			}
		}
	}
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeTitlePreview() {
	TheProspectorTheme {
		// A surface container using the 'background' color from the theme
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colors.background
		) {
			NoteScreen(
				notes = NoteDataDummy().loadNotes(),
				onAddNote = {},
				onRemoveNote = {},
				onEditNote = {})
		}

	}
}