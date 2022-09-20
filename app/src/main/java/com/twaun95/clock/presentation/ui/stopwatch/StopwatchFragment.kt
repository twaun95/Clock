package com.twaun95.clock.presentation.ui.stopwatch

import com.twaun95.clock.R
import com.twaun95.clock.databinding.FragmentStopwatchBinding
import com.twaun95.clock.presentation.adapter.StopWatchLapAdapter
import com.twaun95.clock.presentation.extensions.setOnSingleClickListener
import com.twaun95.clock.presentation.ui.main.MainActivityViewModel
import com.twaun95.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StopwatchFragment :
    BaseFragment<FragmentStopwatchBinding, StopwatchFragmentViewModel, MainActivityViewModel>(
        R.layout.fragment_stopwatch
    ) {
    override val activityVM: MainActivityViewModel by sharedViewModel()
    override val fragmentVM: StopwatchFragmentViewModel by viewModel()

    private val lapAdapter by lazy { StopWatchLapAdapter() }

    override fun initView() {
        super.initView()

        binding.fragmentVM = this.fragmentVM
        binding.rvLap.adapter = lapAdapter
    }

    override fun setObserver() {
        super.setObserver()
    }

    override fun setEvent() {
        super.setEvent()

        binding.buttonReset.setOnSingleClickListener {
            fragmentVM.reset()
            lapAdapter.update(this.fragmentVM.lapList)
        }

        binding.buttonLap.setOnSingleClickListener {
            this.fragmentVM.addLapTime()
            lapAdapter.update(this.fragmentVM.lapList)
            binding.rvLap.scrollToPosition(0)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        fragmentVM.pauseTimer()
    }

    companion object {
        fun getInstance(): StopwatchFragment = StopwatchFragment()
    }
}