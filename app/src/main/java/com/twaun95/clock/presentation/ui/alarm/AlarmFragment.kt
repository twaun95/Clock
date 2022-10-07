package com.twaun95.clock.presentation.ui.alarm

import com.twaun95.clock.R
import com.twaun95.clock.databinding.FragmentAlarmBinding
import com.twaun95.clock.presentation.extensions.setOnSingleClickListener
import com.twaun95.clock.presentation.ui.main.MainActivityViewModel
import com.twaun95.clock.presentation.utils.ClockToast
import com.twaun95.clock.handler.PushAlarmHandler
import com.twaun95.core.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlarmFragment : BaseFragment<FragmentAlarmBinding, AlarmFragmentViewModel, MainActivityViewModel>(
    R.layout.fragment_alarm) {
    override val activityVM: MainActivityViewModel by sharedViewModel()
    override val fragmentVM: AlarmFragmentViewModel by viewModel()

    private val alarmHandler by inject<PushAlarmHandler>()

    override fun initView() {
        super.initView()
    }

    override fun setObserver() {
        super.setObserver()
    }

    override fun setEvent() {
        super.setEvent()

        binding.buttonRegister.setOnSingleClickListener {
            ClockToast.show(requireContext(), "푸시 알람(${binding.timePicker.hour}:${binding.timePicker.minute})이 등록되었습니다.")
            alarmHandler.setAlarm(binding.timePicker.hour, binding.timePicker.minute, "메세지 테스트.")
            alarmHandler.isRegistered()
        }
    }



    companion object {
        fun getInstance() : AlarmFragment = AlarmFragment()
    }
}