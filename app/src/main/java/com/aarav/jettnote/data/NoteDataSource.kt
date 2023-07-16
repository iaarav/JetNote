package com.aarav.jettnote.data


import com.aarav.jettnote.model.Note

class NoteDataSource{
    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "Heyy" , description = "Heyy There. This is My First Note!!"),
            Note(title = "Morning" , description = "This is a nice morning"),
            Note(title = "Coffee" , description = "I woke up and made coffee"),
            Note(title = "Laundry" , description = "Today is Laundry Day"),
            Note(title = "I" , description = "I seem dumb rightt? =) ")
        )
    }
}