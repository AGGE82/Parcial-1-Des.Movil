package com.example.ui_practica

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ui_practica.data.models.User0

@Composable
fun CardUser(
    funNombre: (String) -> Unit,
    funEmail: (String) -> Unit,
    funtxtButton: (String) -> Unit,
    funisEditing: (Boolean) -> Unit,
    fundeleteUser: (String) -> Unit,
    user0: User0
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            Arrangement.Center
        ){
            Text(text = user0.name, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = user0.email, modifier = Modifier.align(Alignment.CenterHorizontally))
            Row(modifier = Modifier.fillMaxWidth()){
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    onClick = {
                        funNombre(user0.name)
                        funEmail(user0.email)
                        funtxtButton("Editar usuario")
                        funisEditing(true)
                    }
                ) {
                    Text(text = "Editar", color = Color.White)
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    onClick = {
                        fundeleteUser(user0.name)
                    }
                ) {
                    Text(text = "Borrar", color = Color.White)
                }
            }
        }
    }
}