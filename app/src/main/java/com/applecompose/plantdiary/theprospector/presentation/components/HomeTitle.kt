package com.applecompose.plantdiary.theprospector.presentation.components

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Map
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applecompose.plantdiary.theprospector.R
import com.applecompose.plantdiary.theprospector.ui.theme.newBackgroundColor
import java.util.Map

@Composable
fun HomeTitle() {

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
				contentDescription = "Location icon"


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
					contentDescription = "Delete"


				)
			}
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
		HomeTitle()
	}
}