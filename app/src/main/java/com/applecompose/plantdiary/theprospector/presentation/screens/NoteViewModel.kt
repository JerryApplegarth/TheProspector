package com.applecompose.plantdiary.theprospector.presentation.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.applecompose.plantdiary.theprospector.data.NoteDataDummy
import com.applecompose.plantdiary.theprospector.data.model.Note

class NoteViewModel: ViewModel() {

	var noteList = mutableStateListOf<Note>()

	init {
		noteList.addAll(NoteDataDummy().loadNotes())
	}

	fun addNote(note: Note) {
		noteList.add(note)
	}
	fun removeNote(note: Note) {
		noteList.remove(note)
	}
	fun getAllNotes(): List<Note> {
		return noteList
	}





}