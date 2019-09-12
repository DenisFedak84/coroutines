package com.fedak.denis.mvvmcoroutine.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity(){

    @Inject
    protected lateinit var viewModelProviderFactory: ViewModelProviderFactory

    public fun replaceFragment(fragment: BaseFragment, @IdRes container: Int) {

        supportFragmentManager
            .beginTransaction()
            .replace(container, fragment)
            .commit()
    }

    public fun addFragment(fragment: BaseFragment, @IdRes container: Int) {

        supportFragmentManager
            .beginTransaction()
            .add(container, fragment)
            .addToBackStack(fragment.toString())
            .commit()
    }

    fun <T : ViewModel> getViewModel(target: AppCompatActivity, viewModelClass: Class<T>) =
    ViewModelProvider(this, viewModelProviderFactory).get(viewModelClass)
}