package com.example.pertemuan14.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan14.MahasiswaApplications
import com.example.pertemuan14.ui.home.viewmodel.HomeViewModel
import com.example.pertemuan14.ui.home.viewmodel.InsertViewModel


object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                MahasiswaApplications().container.repositoryMhs)
        }
        initializer {
            InsertViewModel(
                MahasiswaApplications().container.repositoryMhs
            )
        }
    }
}


fun CreationExtras.MahasiswaApplications(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)