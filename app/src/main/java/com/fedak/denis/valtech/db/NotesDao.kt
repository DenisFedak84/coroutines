package com.fedak.denis.mvvmcoroutine.db

import androidx.room.*

@Dao
interface NotesDao {

    @Query("SELECT * FROM users")
    suspend fun getAll(): List<NotesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: NotesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: ArrayList<NotesEntity>)

    @Query("SELECT * FROM users WHERE _id=:id")
    suspend fun getById(id: Int): NotesEntity

    @Update
    suspend fun update(entity: NotesEntity)

    @Delete
    suspend fun delete(entity: NotesEntity)

    @Query("DELETE FROM users")
    suspend fun deleteAll()
}