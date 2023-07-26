package com.aarav.jettnote.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID
@Entity("tableOfNotes")
data class Note(
    @PrimaryKey val id: UUID = UUID.randomUUID(),

    @ColumnInfo("Note_Title") val title: String,

    @ColumnInfo("Note_Description") val description: String,

    @ColumnInfo("Note_entryDate") val entryDate: Date = Date.from(Instant.now()))