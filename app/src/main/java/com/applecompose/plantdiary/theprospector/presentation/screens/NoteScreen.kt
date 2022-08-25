package com.applecompose.plantdiary.theprospector.presentation.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.PictureInPicture
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applecompose.plantdiary.theprospector.R
import com.applecompose.plantdiary.theprospector.data.NoteDataDummy
import com.applecompose.plantdiary.theprospector.data.model.Note
import com.applecompose.plantdiary.theprospector.maps.MyGoogleMap
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
	val textState = remember {
		mutableStateOf(TextFieldValue)
	}
	var title by remember { mutableStateOf("") }
	var description by remember { mutableStateOf("") }
	var latitude by remember { mutableStateOf("")}
	var longitude by remember { mutableStateOf("")}
	val context = LocalContext.current
	val localContext = LocalContext.current
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(start = 12.dp)
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
		Spacer(modifier = Modifier.height(6.dp))
		Text(text = stringResource(R.string.add_a_new_prospect))
		Row(
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier.fillMaxWidth()
		) {
			Column(
				modifier = Modifier
					.padding(8.dp)
			) {
				Text(text = "Latitude: ")
				Text(text = "Longitude: ")
			}
			Icon(
				imageVector = Icons.Default.Map,
				contentDescription = stringResource(R.string.map_icon),
				modifier = Modifier
					.padding(end = 16.dp)
					.clickable {
						localContext.startActivity(Intent(localContext, MyGoogleMap::class.java))
					}
				)
		}
		Divider(
			color = MaterialTheme.colors.primary,
			thickness = 2.dp
		)
		NoteInputText(
			modifier = Modifier
				.fillMaxWidth()
				.padding(end = 6.dp)
				.padding(6.dp),
			text = title,
			label = stringResource(R.string.title_of_prospect),
			onTextChange = {
				title = it
			}
		)
		NoteInputText(
			modifier = Modifier
				.fillMaxWidth()
				.padding(bottom = 6.dp, start = 6.dp, end = 12.dp),
			text = description,
			label = stringResource(R.string.describe_the_prospect),
			onTextChange = {
				description = it
			},
		)
		NoteInputText(
			modifier = Modifier
				.fillMaxWidth()
				.padding(bottom = 6.dp, end = 12.dp),
			text = latitude,
			label = stringResource(R.string.latitude),
			onTextChange = {
				latitude = it
			},
		)
		NoteInputText(
			modifier = Modifier
				.fillMaxWidth()
				.padding(bottom = 6.dp, end = 12.dp),
			text = longitude,
			label = stringResource(R.string.longitude),
			onTextChange = {
				longitude = it
			},
		)
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(6.dp)
				.padding(end = 16.dp),
			horizontalArrangement = Arrangement.SpaceBetween
		) {

			Icon(
				imageVector = Icons.Default.Save,
				contentDescription = stringResource(R.string.save_icon),
				modifier = Modifier
					.clickable {
						if (title.isNotEmpty() && description.isNotEmpty()
							&& latitude.isNotEmpty() && longitude.isNotEmpty()) {
							onAddNote(
								Note(
									title = title,
									description = description,
									latitude = latitude,
									longitude = longitude
								)
							)
							title = ""
							description = ""
							latitude = ""
							longitude = ""
							Toast.makeText(
								context, "Your $title, " +
										"$description, " +
										"$latitude and " +
										"$longitude was added",
								Toast.LENGTH_SHORT
							).show()
						}
					}
			)
			Text(
				text = stringResource(R.string.add_a_picture),
				modifier = Modifier
					.padding(end = 48.dp)
					.width(200.dp),
				textAlign = TextAlign.End
			)
			Icon(
				imageVector = Icons.Default.PictureInPicture,
				contentDescription = stringResource(R.string.add_picture),
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
						onEditNote(
							Note(
								title = title + textState.value.toString(),
								description = description + textState.value.toString(),
								latitude = latitude + textState.value.toString(),
								longitude = longitude + textState.value.toString()
							)
						)
						title = ""
						description = ""
						Toast.makeText(context, "Your text was edited", Toast.LENGTH_SHORT).show()


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