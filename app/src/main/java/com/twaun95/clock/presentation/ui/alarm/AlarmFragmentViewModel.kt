package com.twaun95.clock.presentation.ui.alarm

import com.twaun95.clock.common.MutableNonNullLiveData
import com.twaun95.core.base.BaseViewModel

class AlarmFragmentViewModel : BaseViewModel() {

    val viewState by lazy { MutableNonNullLiveData<AlarmViewState>(AlarmViewState.IDLE) }

}