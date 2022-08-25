package com.applecompose.plantdiary.theprospector.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.applecompose.plantdiary.theprospector.data.model.Note
import com.applecompose.plantdiary.theprospector.utils.DateConverter
import com.applecompose.plantdiary.theprospector.utils.UUIDConverter

@Database(entities = [Note::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {

	abstract fun noteDao(): NoteDatabaseDao

}
