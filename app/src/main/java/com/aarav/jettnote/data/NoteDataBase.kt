package com.aarav.jettnote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aarav.jettnote.model.Note

@Database(entities = [Note::class], version =1, exportSchema = false)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDataBaseDAO
}