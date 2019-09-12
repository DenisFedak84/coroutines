package com.fedak.denis.mvvmcoroutine.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class NotesEntity constructor(
    @ColumnInfo(name = "_id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "username") val userName: String,
    @ColumnInfo(name = "link") val link: String
)