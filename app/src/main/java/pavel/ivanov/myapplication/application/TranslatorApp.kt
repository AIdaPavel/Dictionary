package pavel.ivanov.myapplication.application

import android.app.Application
import org.koin.core.context.startKoin
import pavel.ivanov.myapplication.di.application
import pavel.ivanov.myapplication.di.mainScreen

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }

}
