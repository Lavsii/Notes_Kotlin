package com.lavsii.noteskotlin.database

import androidx.lifecycle.LiveData
import com.lavsii.noteskotlin.models.AppNote

interface DatabaseRepository {
    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess: () -> Unit)
    suspend fun delete(note: AppNote, onSuccess: () -> Unit)
}