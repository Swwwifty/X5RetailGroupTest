package ru.egorkastr.x5retailtest.presentation.common

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.egorkastr.x5retailtest.presentation.di.shopDataModule
import ru.egorkastr.x5retailtest.presentation.di.shopModule

/**
 * My application class
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(shopModule, shopDataModule))
        }
    }

}