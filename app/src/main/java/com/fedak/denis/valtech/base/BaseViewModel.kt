package com.fedak.denis.mvvmcoroutine.base

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

   open val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

     open fun getLoading () : MutableLiveData<Int>{
         return loadingVisibility
     }

     open fun startLoading() {
        loadingVisibility.value = View.VISIBLE
    }

    open fun finishLoading() {
        loadingVisibility.value = View.GONE
    }


}