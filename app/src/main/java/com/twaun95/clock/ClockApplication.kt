package com.twaun95.clock

import android.app.Application
import com.twaun95.clock.di.modules.LogModule
import com.twaun95.clock.di.modules.ViewModelModule
import com.twaun95.core.logger.ActivityLifecycleLogger
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ClockApplication : Application() {

    private val activityLifeCycleLogger by inject<ActivityLifecycleLogger>()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ClockApplication)
            modules(
                LogModule.module,
                ViewModelModule.module
            )
        }
        registerActivityLifecycleCallbacks(activityLifeCycleLogger)
    }
}