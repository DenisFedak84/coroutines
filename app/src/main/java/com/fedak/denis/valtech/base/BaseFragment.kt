package com.fedak.denis.mvvmcoroutine.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseFragment : Fragment(){

    protected fun <T : ViewModel> getViewModel(target: AppCompatActivity, viewModelClass: Class<T>) =
        ViewModelProviders.of(target).get(viewModelClass)
}