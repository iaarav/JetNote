package com.aarav.jettnote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aarav.jettnote.model.Note
import com.aarav.jettnote.util.DateConvertor

@Database(entities = [Note::class], version =2, exportSchema = false)
@TypeConverters(DateConvertor::class)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDataBaseDAO
}