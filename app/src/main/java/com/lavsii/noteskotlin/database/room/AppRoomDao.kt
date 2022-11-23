package com.lavsii.noteskotlin.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.lavsii.noteskotlin.models.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * from notes_table")
    fun getAllNotes(): LiveData<List<AppNote>>

    @Insert(onConflict = IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)
}