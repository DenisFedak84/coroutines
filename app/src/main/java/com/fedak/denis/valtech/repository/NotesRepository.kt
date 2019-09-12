package com.fedak.denis.valtech.repository


import com.fedak.denis.mvvmcoroutine.db.NotesDao
import com.fedak.denis.mvvmcoroutine.db.NotesEntity
import com.fedak.denis.mvvmcoroutine.mapper.NotesMapper
import com.fedak.denis.mvvmcoroutine.model.StackOverflowModel
import com.fedak.denis.valtech.model.NotesModel
import com.fedak.denis.valtech.network.NotesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.logging.Logger
import javax.inject.Inject

class NotesRepository @Inject constructor(
    private val notesApi: NotesApi,
    private val notesDao: NotesDao,
    private val mapper: NotesMapper
) {

    val Log = Logger.getLogger("Den")

    suspend fun getNotes(): List<NotesModel> = withContext(Dispatchers.IO) {

        val dbData = getAllNotesInDB()
        if(dbData.isNotEmpty()){
            return@withContext dbData
        }else{
            val restData = getDataFromREST()
            Log.warning("Get data in REST =" + restData.size.toString())
            saveNotesInDB(mapper.notesToEntities(restData))
            return@withContext restData
        }
    }

    suspend fun getDataFromREST(): List<NotesModel> {
        var rest: StackOverflowModel? = null

        try {
            rest = notesApi.getNotes(1, 10).await()
        } catch (e: Exception) {
            println("Error")
        }
        return mapper.restEntityToNotes(rest)
    }

    private suspend fun getAllNotesInDB(): List<NotesModel> {
        var db: List<NotesEntity> = arrayListOf()

        try {
            db = notesDao.getAll()
            Log.warning("Get data in DB =" + db.size.toString())
        } catch (e: Exception) {
            println("Error")
        }

        return mapper.dbEntitiesToNotes(db)
    }

    suspend fun saveNotesInDB(data: ArrayList<NotesEntity>) : Int = withContext(Dispatchers.IO) {
        try {
            notesDao.insertAll(data)
            Log.warning("Save data in DB =" + data.size.toString())
            return@withContext data.size
        } catch (e: Exception) {
            println("Error")
            return@withContext 0
        }
    }

    suspend fun getNotesById (id :Int) : NotesModel = withContext(Dispatchers.IO){
        var note: NotesEntity? = null

        try {
            note = notesDao.getById(id)
        }catch (e:Exception){
            println("Error")
        }

        return@withContext mapper.dbEntityToNote(note)
    }

}