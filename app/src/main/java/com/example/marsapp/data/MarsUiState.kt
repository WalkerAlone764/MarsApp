package com.example.marsapp.data

sealed interface MarsUiState {
    data class Success(val photo: List<MarsPhoto>): MarsUiState
    object Loading: MarsUiState
    object Error: MarsUiState
}
