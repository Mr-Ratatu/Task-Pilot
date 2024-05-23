package renat.task.pilot

import android.app.Application
import android.content.Context
import org.koin.dsl.module
import renat.task.pilot.di.initKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(
            module {
                single<Context> { this@App }
            }
        )
    }
}