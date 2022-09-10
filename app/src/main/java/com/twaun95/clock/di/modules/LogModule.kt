package com.twaun95.clock.di.modules

import com.twaun95.clock.common.Logger
import com.twaun95.clock.di.KoinModule
import com.twaun95.core.logger.ActivityLifecycleLogger
import com.twaun95.core.logger.LogSupplier
import org.koin.dsl.module

object LogModule : KoinModule {

    override val module = module {
        single<LogSupplier> { LogSupplierImpl() }
        single { ActivityLifecycleLogger(get()) }
    }
}

internal class LogSupplierImpl : LogSupplier {

    override fun log(message: String) {
        Logger.d(message)
    }
}