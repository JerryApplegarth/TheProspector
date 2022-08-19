package com.applecompose.plantdiary.theprospector.maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState


class MyGoogleMap : ComponentActivity() {

	//private val viewModel : NoteViewModel by viewModel<NoteViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MyMap()
		}
	}

	@Composable
	private fun MyMap() {
		val roseburg = LatLng(43.21, -123.32)
		val cameraPosition = rememberCameraPositionState{
			position = CameraPosition.fromLatLngZoom(roseburg, 12f)
		}

		GoogleMap(
			modifier = Modifier
				.fillMaxSize(),
			cameraPositionState = cameraPosition
		) {
			Marker(
				draggable = true,
				title = "Roseburg",
				snippet = "Marker in Roseburg"
			)


		}
	}



}

