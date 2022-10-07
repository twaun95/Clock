package com.twaun95.clock.di.modules

import com.twaun95.clock.di.KoinModule
import com.twaun95.clock.handler.PushAlarmHandler
import com.twaun95.clock.handler.VibrationHandler
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object HandlerModule : KoinModule {
    override val module: Module
        get() = module {
            single { PushAlarmHandler(androidApplication()) }
            single { VibrationHandler(androidContext()) }
        }
}