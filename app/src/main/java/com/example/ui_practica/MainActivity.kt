package com.example.ui_practica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_practica.data.models.User0
import com.example.ui_practica.theme.UipracticaTheme
import com.example.ui_practica.ui.navigation.NavManagement
import com.example.ui_practica.ui.viewmodels.NewUsersViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UipracticaTheme {
                //val userList = remember { mutableStateListOf<User0>() }
                NavManagement(NewUsersViewModel())
                //ScreenCRUD(userList)
            }
        }
    }
}

@Composable
fun ScreenCRUD(userList: MutableList<User0>){
    var nombre by remember { mutableStateOf("")   }
    var email by remember { mutableStateOf("")   }
    var isEditing by remember { mutableStateOf(false)   }
    var txtButton by remember { mutableStateOf("Agregar Usuario")   }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ){
            Formulario(
                nombre = nombre,
                funNombre = { nombre = it},
                email = email,
                funEmail = { email = it},
                isEditing = isEditing,
                funisEditing = { isEditing = false },
                txtButton = txtButton,
                funtxtButton = { txtButton = it},
                userList = userList,
                funResetCampos = {
                    nombre = ""
                    email = ""
                }
            )
            Column(modifier = Modifier.fillMaxWidth()){
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ){
                    items(userList){user ->
                        CardUser(
                            funNombre = { nombre = it},
                            funEmail = { email = it},
                            funtxtButton = { txtButton = it},
                            funisEditing = { isEditing  = it},
                            fundeleteUser = { deleteUser(it, userList)},
                            user0 = user
                        )

                    }
                }
            }
        }
    }
}

fun addUser(nombre: String, email: String, number: String, userList: SnapshotStateList<User0>){
    userList.add(User0(nombre, email, number))
}

fun editUser(nombre: String, email: String, number: String, userList: MutableList<User0>){
    userList.forEach { user ->
        if ( user.name == nombre){
            user.email = email
            user.number = number
        }
    }
}
fun deleteUser(nombre: String, userList: MutableList<User0>){
    userList.forEach { user ->
        if ( user.name == nombre){
            userList.remove(user)
        }
    }
}

@Composable
fun CardStory() {

    Surface (
        shadowElevation = 40.dp,
        modifier = Modifier.clip(RoundedCornerShape(5.dp))
    ){
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(
                R.drawable.profile),
                "Perfil",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(50.dp)
                    .width(50.dp)
            )
            Text("Nombre")
        }
    }
}

@Composable
fun CardMessage(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Image(painterResource(
        R.drawable.profile),
        "Perfil",
        modifier = Modifier
            .clip(CircleShape)
            .height(50.dp)
            .width(50.dp)
        )
        Column(
            modifier = Modifier.padding(10.dp)
        ){
            Text("Nombre")
            Text("Last Message: ")
        }
//        Text("→", fontSize = 30.sp)
        Icon(Icons.Rounded.ArrowForward, "", modifier = Modifier
            .fillMaxWidth())
    }
}

@Composable
fun CardPost(){
    Surface (
        shadowElevation = 40.dp,
        modifier = Modifier.clip(RoundedCornerShape(5.dp))
    ){
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ){
            Row(
            modifier = Modifier.padding(10.dp)
            ){
                Image(painterResource(
                    R.drawable.profile),
                    "Perfil",
                    modifier = Modifier
                        .clip(CircleShape)
                        .height(50.dp)
                        .width(50.dp)
                )
                Text("Nombre")
                Icon(Icons.Rounded.MoreVert, contentDescription = "")
            }
            Text("Relajao")
            Image(painterResource(
                R.drawable.postimage),
                "Perfil",
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row(){
                Icon(Icons.Rounded.Favorite, contentDescription = "")
                Icon(Icons.Rounded.MailOutline, contentDescription = "")
            }
            Row(){
                Text("0 likes")
                Text("|")
                Text("0 comments")
            }
        }
    }
}

@Composable
fun Init() {
    Column(){
        Row(){
            CardStory()
            CardStory()
            CardStory()
        }
        CardMessage()
        CardMessage()
        CardMessage()
        CardPost()
    }

}

@Preview(showBackground = true)
@Composable
fun Preview(){
    NavManagement(NewUsersViewModel())
}