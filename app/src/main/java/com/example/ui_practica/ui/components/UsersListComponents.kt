package com.example.ui_practica.ui.components


import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ButtonRegresar0( function: () -> Unit) {
    Button(
        onClick = { function() }
    ) {
        Text(text = "Regresar")
    }
}

@Composable
fun ButtonDetalles ( function: () -> Unit) {
    Button(
        onClick = { function() }
    ) {
        Text(text = "Detalles")
    }
}