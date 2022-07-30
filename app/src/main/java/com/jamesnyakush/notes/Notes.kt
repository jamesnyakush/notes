package com.jamesnyakush.notes

import android.app.Application
import androidx.annotation.Nullable
import com.jamesnyakush.notes.di.databaseModule
import com.jamesnyakush.notes.di.repositoryModule
import com.jamesnyakush.notes.di.viewModelModule
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import org.koin.core.logger.Level
import timber.log.Timber

class Notes : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
    }


    /**
     *  This is a function that help us do dependency  Injection
     *
     *      - Data module (caching data locally that is room or datastore).
     *      - Repository modules (contains business logic).
     *
     */
    private fun initKoin() {
        try {
            startKoin {
                androidLogger(Level.ERROR)
                androidContext(applicationContext)
                modules(
                    listOf(repositoryModule, viewModelModule, databaseModule)
                )
            }
        } catch (error: KoinAppAlreadyStartedException) {
            Timber.e(error.localizedMessage)
        }
    }


    /**
     * This a function that helps in logging  on debug mode
     *
     * We can also send Log msgs to firebase crashlytics for production debugging
     *
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                @Nullable
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        }
        //TODO: Add Crashlytics
//        else {
//            //Timber.plant(CrashlyticsTree())
//        }
    }


}