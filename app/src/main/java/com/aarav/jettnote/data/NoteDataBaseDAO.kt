package com.aarav.jettnote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aarav.jettnote.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDataBaseDAO{

    @Query("SELECT * from tableOfNotes")
    fun getAllNotes():
            Flow<List<Note>>

    @Query("SELECT * from tableOfNotes where id=  :id")
    suspend fun getNoteById(id:String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note:Note)

    @Query("DELETE from tableOfNotes")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note:Note)

}
