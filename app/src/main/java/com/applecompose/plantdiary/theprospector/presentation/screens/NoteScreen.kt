package com.applecompose.plantdiary.theprospector.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PictureInPicture
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applecompose.plantdiary.theprospector.R
import com.applecompose.plantdiary.theprospector.data.NoteDataDummy
import com.applecompose.plantdiary.theprospector.data.model.Note
import com.applecompose.plantdiary.theprospector.presentation.components.NoteInputText
import com.applecompose.plantdiary.theprospector.ui.theme.cardBackground
import com.applecompose.plantdiary.theprospector.ui.theme.newBackgroundColor
import java.time.format.DateTimeFormatter

@Composable
fun NoteScreen(
	notes: List<Note>,
	onAddNote: (Note) -> Unit,
	onRemoveNote: (Note) -> Unit
) {
	var title by remember { mutableStateOf("")}
	var description by remember { mutableStateOf("")}
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
			.background(MaterialTheme.colors.newBackgroundColor),
		horizontalAlignment = Alignment.Start,
		verticalArrangement = Arrangement.Top
	) {
		TopAppBar(title = {
			Text(text = stringResource(id = R.string.app_name))
		},
		backgroundColor = MaterialTheme.colors.cardBackground
		)

		Divider(color = MaterialTheme.colors.secondary,
			thickness = 2.dp)
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
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.End
			) {
//				Icon(
//					painter = painterResource(id = R.drawable.ic_delete),
//					contentDescription = "Delete",
//					modifier = Modifier
//						.clickable {  }
//				)
			}
		}
		//input text goes here
		Divider(color = MaterialTheme.colors.secondary,
			thickness = 2.dp)
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
							//save to list
							title = ""
							description = ""
						}

					}
				)

			Icon(
				imageVector = Icons.Default.PictureInPicture,
				contentDescription = "Add Picture",
				modifier = Modifier
					.clickable {

				}
			)

		}
		Divider(color = MaterialTheme.colors.secondary, thickness = 2.dp)
		Spacer(modifier = Modifier.height(6.dp))
		LazyColumn {
			items(notes) { note ->
				NoteRow(
					note = note,
					onNoteClicked = {})
				
			}
		}



	}
}

@Composable
fun NoteRow(
	modifier: Modifier = Modifier,
	note: Note,
	onNoteClicked: (Note) -> Unit
	) {
	Surface(
		modifier
			.padding(4.dp)
			.clip(RoundedCornerShape(16.dp))
			.fillMaxWidth(),
		color = MaterialTheme.colors.cardBackground,
		elevation = 6.dp
	) {
		Column(
			modifier
				.padding(
					horizontal = 14.dp,
					vertical = 6.dp),
			horizontalAlignment = Alignment.Start
		) {
			Text(
				text = note.title,
				style = MaterialTheme.typography.subtitle2
				)
			Text(
				text = note.description,
				style = MaterialTheme.typography.subtitle1
				)
			Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")))
			Icon(
				painter = painterResource(id = R.drawable.ic_delete),
				contentDescription = "Delete",
				modifier = Modifier
					.align(Alignment.End)
					.clickable { }
			)




		}

	}


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeTitlePreview() {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colors.newBackgroundColor
	) {
		NoteScreen(
			notes = NoteDataDummy().loadNotes(),
			onAddNote = {},
			onRemoveNote = {})
	}
}