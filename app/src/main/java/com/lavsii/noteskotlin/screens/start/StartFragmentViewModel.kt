package com.lavsii.noteskotlin.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.lavsii.noteskotlin.database.room.AppRoomDatabase
import com.lavsii.noteskotlin.database.room.AppRoomRepository
import com.lavsii.noteskotlin.utilits.REPOSITORY
import com.lavsii.noteskotlin.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}