package com.fedak.denis.valtech.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fedak.denis.mvvmcoroutine.base.BaseViewModel
import com.fedak.denis.valtech.model.NotesModel
import com.fedak.denis.valtech.repository.NotesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val notesRepository: NotesRepository) : BaseViewModel() {

    var data: MutableLiveData<List<NotesModel>> = MutableLiveData()

    fun getNotes() : MutableLiveData<List<NotesModel>> {
        startLoading()
        viewModelScope.launch  { data.postValue(notesRepository.getNotes()) }
        return data
    }
}