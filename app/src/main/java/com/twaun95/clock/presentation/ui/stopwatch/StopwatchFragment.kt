package com.twaun95.clock.presentation.ui.stopwatch

import com.twaun95.clock.R
import com.twaun95.clock.databinding.FragmentStopwatchBinding
import com.twaun95.clock.presentation.extensions.setOnSingleClickListener
import com.twaun95.clock.presentation.ui.main.MainActivityViewModel
import com.twaun95.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StopwatchFragment : BaseFragment<FragmentStopwatchBinding, StopwatchFragmentViewModel, MainActivityViewModel>(
    R.layout.fragment_stopwatch) {
    override val activityVM: MainActivityViewModel by sharedViewModel()
    override val fragmentVM: StopwatchFragmentViewModel by viewModel()

    override fun initView() {
        super.initView()
    }

    override fun setObserver() {
        super.setObserver()
    }

    override fun setEvent() {
        super.setEvent()

        binding.buttonReset.setOnSingleClickListener {

        }

        binding.buttonPlayStop.setOnSingleClickListener {

        }

        binding.buttonLap.setOnSingleClickListener {

        }
    }

    companion object {
        fun getInstance() : StopwatchFragment = StopwatchFragment()
    }
}