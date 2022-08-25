package com.applecompose.plantdiary.theprospector.data

import com.applecompose.plantdiary.theprospector.data.model.Note

class NoteDataDummy {

	fun loadNotes(): List<Note> {
		return listOf(
			Note(title = "Spring Canyon Prospect",
				description = "This prospect showed a little gold",
				latitude = 43.2345.toString(),
				longitude = (-123.3432).toString()
				),


		)

	}

}