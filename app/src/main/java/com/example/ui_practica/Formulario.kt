package com.example.ui_practica

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.ui_practica.data.models.User0

@Composable
fun Formulario(
    nombre: String,
    funNombre: (String) -> Unit,
    email: String,
    funEmail: (String) -> Unit,
    isEditing: Boolean,
    funisEditing: () -> Unit,
    txtButton: String,
    funtxtButton: (String) -> Unit,
    userList: MutableList<User0>,
    funResetCampos: () -> Unit
){
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = {funNombre(it)},
        label = { Text(text = "Nombre")},
        enabled = !isEditing
    )
    Spacer(modifier = Modifier.padding(vertical= 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        onValueChange = {funEmail(it)},
        label = { Text(text = "Email")}
    )
    Spacer(modifier = Modifier.padding(vertical= 8.dp))
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.DarkGray),
        onClick = {
            if (isEditing) {
                //editUser(nombre, email, number, userList)
                funtxtButton("Agregar Usuario")
                funisEditing()
            } else {
                //addUser(nombre, email, number, userList)
            }
            funResetCampos()
        }
    ){
        Text(
            color = Color.White,
            text = txtButton
        )
    }
}

