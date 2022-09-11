package com.twaun95.clock.presentation.ui.timer

import android.os.Handler
import android.os.Looper
import com.twaun95.clock.R
import com.twaun95.clock.databinding.FragmentTimerBinding
import com.twaun95.clock.presentation.extensions.setOnSingleClickListener
import com.twaun95.clock.presentation.ui.main.MainActivityViewModel
import com.twaun95.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.concurrent.thread

class TimerFragment : BaseFragment<FragmentTimerBinding, TimerFragmentViewModel, MainActivityViewModel>(
    R.layout.fragment_timer) {
    override val activityVM: MainActivityViewModel by sharedViewModel()
    override val fragmentVM: TimerFragmentViewModel by viewModel()

    override fun initView() {
        super.initView()

        binding.fragmentVM = fragmentVM
    }

    override fun setObserver() {
        super.setObserver()

    }

    override fun setEvent() {
        super.setEvent()
        binding.buttonStart.setOnSingleClickListener {
            thread(true){
                for(i in 1..101) {
                    Thread.sleep(25)
                    this.fragmentVM.progressValue.postValue(this.fragmentVM.progressValue.value.plus(1))
                }
            }
        }
    }

    companion object {
        fun getInstance() : TimerFragment = TimerFragment()
    }
}