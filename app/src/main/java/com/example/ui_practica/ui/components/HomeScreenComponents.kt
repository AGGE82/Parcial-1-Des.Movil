package com.example.ui_practica.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ButtonNewUserPage( function: () -> Unit) {
    Button(
        onClick = { function() }
    ) {
        Text(text = "Nuevo Contacto")
    }
}

@Composable
fun ButtonUserListPage(enabled: Boolean, function: () -> Unit) {
    Button(
        onClick = { function() }, enabled = enabled
    ) {
        Text(text = "Lista Contactos")
    }
}
