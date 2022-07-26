package com.applecompose.plantdiary.theprospector.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applecompose.plantdiary.theprospector.R
import com.applecompose.plantdiary.theprospector.presentation.components.NoteInputText
import com.applecompose.plantdiary.theprospector.ui.theme.newBackgroundColor

@Composable
fun NoteScreen() {
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
		Text(
			text = "The Prospector",
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold,
			fontStyle = FontStyle.Normal,
			fontFamily = FontFamily.SansSerif
		)
		Divider(color = MaterialTheme.colors.secondary, thickness = 2.dp)
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
				Icon(
					painter = painterResource(id = R.drawable.ic_delete),
					contentDescription = "Delete",
					modifier = Modifier
						.clickable {  }


				)
			}

		}
		//input text goes here
		Divider(color = MaterialTheme.colors.secondary, thickness = 2.dp)
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


		Divider(color = MaterialTheme.colors.secondary, thickness = 2.dp)
	}
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeTitlePreview() {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colors.newBackgroundColor
	) {
		NoteScreen()
	}
}