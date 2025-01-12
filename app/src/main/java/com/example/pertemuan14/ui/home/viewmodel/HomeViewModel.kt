package com.example.pertemuan14.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan14.Repository.RepositoryMhs
import com.example.pertemuan14.model.Mahasiswa
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repositoryMhs: RepositoryMhs

): ViewModel() {
    var mhsUIState:HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init{
        getMhs()
    }


    fun getMhs(){
        viewModelScope.launch {
            repositoryMhs.getAllMhs()
                .onStart {
                    mhsUIState = HomeUiState.Loading
                }
                .catch {
                    mhsUIState = HomeUiState.Error(e = it)
                }
                .collect{
                    mhsUIState = if (it.isEmpty()){
                        HomeUiState.Error(Exception("belum ada data mahasiswa"))
                    } else {
                        HomeUiState.Success(it)
                    }
                }
        }
    }
    fun deleteMhs (mahasiswa: Mahasiswa) {
        viewModelScope.launch {
            try {
                repositoryMhs.deleteMhs(mahasiswa)
            }catch (e: Exception){
                mhsUIState = HomeUiState.Error(e)
            }

        }
    }
}

sealed class  HomeUiState {
    object Loading : HomeUiState()

    data class Success(val data:List<Mahasiswa>): HomeUiState()

    data class Error(val e: Throwable) :HomeUiState()
}

