package com.aarav.jettnote.repository

import com.aarav.jettnote.data.NoteDataBase
import com.aarav.jettnote.data.NoteDataBaseDAO
import com.aarav.jettnote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDataBaseDAO: NoteDataBaseDAO) {
    suspend fun addNote(note: Note) = noteDataBaseDAO.insertNote(note)
    suspend fun deleteNote(note: Note) = noteDataBaseDAO.deleteNote(note)
    suspend fun updateNote(note: Note) = noteDataBaseDAO.updateNote(note)
    suspend fun deleteAllNotes() = noteDataBaseDAO.deleteAll()
    fun getAllNotes(): Flow<List<Note>> =
        noteDataBaseDAO.getAllNotes().flowOn(Dispatchers.IO).conflate()
}