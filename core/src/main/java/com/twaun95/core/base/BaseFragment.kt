package com.twaun95.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding, FVM : BaseViewModel, AVM : BaseViewModel>(@LayoutRes private val layoutId: Int) : Fragment(layoutId){

    protected var _binding: VB? = null
    val binding: VB
        get() = _binding ?: throw IllegalStateException("binding fail")

    abstract val fragmentVM : FVM
    abstract val activityVM : AVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setEvent()
        setObserver()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    open fun initView() {}
    open fun setEvent() {}
    open fun setObserver() {}
}