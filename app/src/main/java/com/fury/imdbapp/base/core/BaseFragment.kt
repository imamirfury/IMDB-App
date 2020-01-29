package com.fury.imdbapp.base.core


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
/**
 *
 * Created By Amir Fury on Jan 16 2020
 *
 */

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    @get:LayoutRes
    protected abstract val layoutResId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(container?.context), layoutResId, container, false)
        onFragmentReady(savedInstanceState, rootView as B)
        return rootView.root
    }

    protected abstract fun onFragmentReady(instanceState: Bundle?, binding: B)

}