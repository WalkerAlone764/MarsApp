package com.example.marsapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsapp.data.DefaultMarsPhotoRepositary
import com.example.marsapp.data.MarsApi
import com.example.marsapp.data.MarsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okio.IOException

class MarsViewModel: ViewModel() {

     private val _marsUiState: MutableStateFlow<MarsUiState> = MutableStateFlow(MarsUiState.Loading)
        val  marsUiState: StateFlow<MarsUiState> = _marsUiState

    init {
        getMarsPhoto()
    }

    private fun getMarsPhoto() {
        viewModelScope.launch {
            try {
                val marsRepo = DefaultMarsPhotoRepositary()
                val list = marsRepo.getPhotos()
                _marsUiState.value = MarsUiState.Success(list)


            } catch (_: java.io.IOException) {
                _marsUiState.value = MarsUiState.Error
            }
        }
    }
}