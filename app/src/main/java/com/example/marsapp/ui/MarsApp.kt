package com.example.marsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.marsapp.data.MarsUiState

@Composable
fun MarsApp(
    marsUiState: MarsUiState,
    modifier:Modifier = Modifier
) {
    when(marsUiState) {
        is MarsUiState.Success -> {
            Text(text = marsUiState.photo.toString())

        }
        is MarsUiState.Error -> {
            Text(text = "error")
        }
        is  MarsUiState.Loading -> {
            Text(text = "loading...")
        }

        else -> {}
    }

}