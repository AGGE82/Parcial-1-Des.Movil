package com.example.ui_practica.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable


@Composable
fun TextFieldEmail(email: String, function: (String) -> Unit) {
    TextField(
        value = email, onValueChange = {
            function(it)
        }
    )
}

@Composable
fun TextFieldName(name: String, function: (String) -> Unit) {
    TextField(
        value = name, onValueChange = {
            function(it)
        }
    )
}
@Composable
fun TextFieldNumber(number: String, function: (String) -> Unit) {
    TextField(
        value = number, onValueChange = {
            function(it)
        }
    )
}

@Composable
fun ButtonLogin(enabled: Boolean, function: () -> Unit) {
    Button(
        onClick = { function() }, enabled = enabled
    ) {
        Text(text = "Crear Contacto")
    }
}

@Composable
fun ButtonRegresar( function: () -> Unit) {
    Button(
        onClick = { function() }
    ) {
        Text(text = "Regresar")
    }
}

@Composable
fun ButtonRegister(function: () -> Unit) {
    Button(
        onClick = { function() }
    ) {
        Text(text = "Registrarse")
    }
}