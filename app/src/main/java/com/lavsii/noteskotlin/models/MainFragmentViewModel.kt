package com.lavsii.noteskotlin.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.lavsii.noteskotlin.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
}