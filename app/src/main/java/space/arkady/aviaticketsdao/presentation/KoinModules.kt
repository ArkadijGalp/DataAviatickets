package space.arkady.aviaticketsdao.presentation

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import space.arkady.aviaticketsdao.data.di.dataModule
import space.arkady.aviaticketsdao.data.di.roomModule
import space.arkady.aviaticketsdao.domain.di.domainModule
import space.arkady.aviaticketsdao.domain.viewModelModule

class KoinModules: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinModules)
            modules(listOf(
               roomModule, dataModule, domainModule, viewModelModule
            ))
        }
    }
}