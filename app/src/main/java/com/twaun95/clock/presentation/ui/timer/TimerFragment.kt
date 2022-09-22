package com.twaun95.clock.presentation.ui.timer

import android.widget.EditText
import android.widget.Toast
import androidx.core.view.children
import com.twaun95.clock.R
import com.twaun95.clock.databinding.FragmentTimerBinding
import com.twaun95.clock.presentation.extensions.setOnSingleClickListener
import com.twaun95.clock.presentation.ui.main.MainActivityViewModel
import com.twaun95.clock.presentation.utils.ClockToast
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
        binding.buttonStart.setOnSingleClickListener {
            if (binding.pickerHour.value + binding.pickerMinute.value +binding.pickerSec.value<=0) {
                ClockToast.show(requireContext(), "시간을 선택해주세요!!")
                return@setOnSingleClickListener
            }
            fragmentVM.startTimer(binding.pickerHour.value, binding.pickerMinute.value, binding.pickerSec.value)
        }
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