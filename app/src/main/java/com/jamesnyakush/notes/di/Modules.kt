package com.jamesnyakush.notes.di

import androidx.room.Room
import com.jamesnyakush.notes.data.db.NoteDatabase
import com.jamesnyakush.notes.data.repository.NoteRepository
import com.jamesnyakush.notes.data.repository.NoteRepositoryImpl
import com.jamesnyakush.notes.ui.viewmodel.NoteViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single<NoteRepository> { NoteRepositoryImpl() }
}

val viewModelModule = module {
    viewModel { NoteViewModel() }
}

val databaseModule: Module = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            NoteDatabase::class.java,
            "notes.db"
        ).fallbackToDestructiveMigration().build()
    }
}