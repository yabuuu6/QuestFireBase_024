package com.example.pertemuan14.ui.home.viewmodel



import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

import com.example.pertemuan14.Repository.RepositoryMhs



class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMhs : RepositoryMhs
) : ViewModel()