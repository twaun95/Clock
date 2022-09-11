package com.twaun95.clock.di.modules

import com.twaun95.clock.di.KoinModule
import com.twaun95.clock.presentation.ui.alarm.AlarmFragmentViewModel
import com.twaun95.clock.presentation.ui.main.MainActivityViewModel
import com.twaun95.clock.presentation.ui.stopwatch.StopwatchFragmentViewModel
import com.twaun95.clock.presentation.ui.timer.TimerFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelModule : KoinModule {
    override val module: Module
        get() = module {
            viewModel { MainActivityViewModel() }
            viewModel { AlarmFragmentViewModel() }
            viewModel { StopwatchFragmentViewModel() }
            viewModel { TimerFragmentViewModel() }
        }
}