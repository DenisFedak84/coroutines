package com.fedak.denis.mvvmcoroutine.mapper

import com.fedak.denis.mvvmcoroutine.db.NotesEntity
import com.fedak.denis.mvvmcoroutine.model.StackOverflowModel
import com.fedak.denis.valtech.model.NotesModel
import javax.inject.Inject

class NotesMapper @Inject constructor() {

    fun restEntityToNotes(restEntity: StackOverflowModel?): List<NotesModel> {
        val data: ArrayList<NotesModel> = arrayListOf()

        if (restEntity?.items != null) {
            for (model in restEntity.items) {
                data.add(NotesModel(model.owner.display_name, model.owner.link))
            }
        }
        return data
    }

    fun dbEntitiesToNotes(dbEntity: List<NotesEntity>): List<NotesModel> {
        val data: ArrayList<NotesModel> = arrayListOf()

        for (model in dbEntity) {
            data.add(NotesModel(model.userName, model.link))
        }

        return data
    }

    fun notesToEntities(notice: List<NotesModel>): ArrayList<NotesEntity> {

        val data: ArrayList<NotesEntity> = arrayListOf()
        notice.forEachIndexed { index, element -> data.add(NotesEntity(index, element.userName, element.link)) }

        return data
    }

    fun dbEntityToNote(dbEntity: NotesEntity?): NotesModel {

        return if (dbEntity != null) {
            NotesModel(dbEntity.userName, dbEntity.link)
        }else{
            NotesModel("error", "error")
        }
    }

}