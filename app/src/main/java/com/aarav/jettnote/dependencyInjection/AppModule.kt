package com.aarav.jettnote.dependencyInjection

import android.content.Context
import androidx.room.Room
import com.aarav.jettnote.data.NoteDataBase
import com.aarav.jettnote.data.NoteDataBaseDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideNotesDAO(noteDataBase: NoteDataBase): NoteDataBaseDAO = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDataBase =
        Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            "Notes_DB"
        )
            .fallbackToDestructiveMigration()
            .build()
}