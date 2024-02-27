package views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ui_practica.R
import com.example.ui_practica.ui.components.ButtonLogin
import com.example.ui_practica.ui.components.ButtonRegresar
import com.example.ui_practica.ui.components.TextFieldEmail
import com.example.ui_practica.ui.components.TextFieldName
import com.example.ui_practica.ui.components.TextFieldNumber
import com.example.ui_practica.ui.viewmodels.NewUsersViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewUser(newUsersViewModel: NewUsersViewModel, navController: NavHostController) {

    val email : String by newUsersViewModel.email.observeAsState("")
    val name : String by newUsersViewModel.name.observeAsState("")
    val number : String by newUsersViewModel.number.observeAsState("")
    val isEnabled : Boolean by newUsersViewModel.isEnabled.observeAsState(false)
    val userList by newUsersViewModel.users.observeAsState()
    //val userList = remember { mutableStateListOf<User0>() }
    Scaffold(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            ButtonRegresar{navController.navigate("Home")}
            Image(
                painterResource(
                R.drawable.config),
                "LoginConfig",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(270.dp)
                    .width(270.dp)
            )
            Text(text = "Nombre")
            TextFieldName(name) { newUsersViewModel.onChange(email, it, number) }
            Text(text = "Numero")
            TextFieldNumber(number) { newUsersViewModel.onChange(email, name, it) }
            Text(text = "Correo")
            TextFieldEmail(email) { newUsersViewModel.onChange(it, name, number) }
            Text(text = "Forgot your password? Don't Click here")
            ButtonLogin(isEnabled) {
                newUsersViewModel.addUser(email, name, number, userList) }
                navController.navigate("UsersList")
            }

        }
    }




