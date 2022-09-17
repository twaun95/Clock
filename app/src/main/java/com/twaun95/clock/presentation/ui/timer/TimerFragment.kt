package com.twaun95.clock.presentation.ui.timer

import android.widget.EditText
import androidx.core.view.children
import com.twaun95.clock.R
import com.twaun95.clock.databinding.FragmentTimerBinding
import com.twaun95.clock.presentation.extensions.setOnSingleClickListener
import com.twaun95.clock.presentation.ui.main.MainActivityViewModel
import com.twaun95.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class TimerFragment : BaseFragment<FragmentTimerBinding, TimerFragmentViewModel, MainActivityViewModel>(
    R.layout.fragment_timer) {
    override val activityVM: MainActivityViewModel by sharedViewModel()
    override val fragmentVM: TimerFragmentViewModel by viewModel()

    override fun initView() {
        super.initView()

        binding.fragmentVM = fragmentVM
        setPicker()
    }

    override fun setEvent() {
        super.setEvent()
//        binding.buttonPlayStop.setOnSingleClickListener {
//            fragmentVM.timerPauseOrPlay()
//            thread(true){
//                for(i in 1..101) {
//                    Thread.sleep(25)
//                    this.fragmentVM.progressValue.postValue(this.fragmentVM.progressValue.value.plus(1))
//                }
//            }
//        }
//        binding.buttonCancelStart.setOnSingleClickListener {
//            fragmentVM.startOrCancel()
//        }
    }

    private fun setPicker() {
        binding.pickerHour.apply {
            children.iterator().forEach {if (it is EditText) it.filters = arrayOfNulls(0) }
            setFormatter { "$it 시간" }
            minValue = 0
            maxValue = 59
        }

        binding.pickerMinute.apply {
            children.iterator().forEach {if (it is EditText) it.filters = arrayOfNulls(0) }
            setFormatter { "$it 분" }
            minValue = 0
            maxValue = 59
        }

        binding.pickerSec.apply {
            children.iterator().forEach {if (it is EditText) it.filters = arrayOfNulls(0) }
            setFormatter { "$it 초" }
            minValue = 0
            maxValue = 59
        }
    }

    companion object {
        fun getInstance() : TimerFragment = TimerFragment()
    }
}