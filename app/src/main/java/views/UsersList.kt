package views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ui_practica.data.models.User0
import com.example.ui_practica.ui.components.ButtonRegresar0
import com.example.ui_practica.ui.viewmodels.UsersListViewModel
import androidx.compose.ui.Modifier
import com.example.ui_practica.ui.components.ButtonDetalles
import com.example.ui_practica.ui.viewmodels.NewUsersViewModel


@Composable
fun UsersList(UsersListViewModel: UsersListViewModel, newUsersViewModel: NewUsersViewModel, navController: NavHostController) {
    //val userList = remember { mutableStateListOf<User0>() }
    val name by UsersListViewModel.name.observeAsState("")
    val number by UsersListViewModel.name.observeAsState("")
    val userList by newUsersViewModel.users.observeAsState()
    val listLength: Int = userList?.size ?: 0
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(12.dp)
    ) {
        ButtonRegresar0 { navController.navigate("Home") }

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "$listLength")
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        items(listLength ) { user ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(20.dp),
                                    Arrangement.Center
                                ) {
                                    Text(
                                        text = name,
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    )
                                    Text(
                                        text = number,
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    )
                                    Row(modifier = Modifier.fillMaxWidth()) {
                                        ButtonDetalles { navController.navigate("ContactDetails") }
                                    }
                                }
                            }
                        }
                    }

            }
        }
    }

    /*
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ){
            Formulario(
                nombre = name,
                funNombre = { name = it},
                email = email,
                funEmail = { email = it},
                isEditing = isEditing,
                funisEditing = { isEditing = false },
                txtButton = txtButton,
                funtxtButton = { txtButton = it},
                userList = userList,
                funResetCampos = {
                    name = ""
                    email = ""
                }
            )
            Column(modifier = Modifier.fillMaxWidth()){
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ){
                    items(userList){user ->
                        CardUser(
                            funNombre = { name = it},
                            funEmail = { email = it},
                            funtxtButton = { txtButton = it},
                            funisEditing = { isEditing  = it},
                            fundeleteUser = { deleteUser(it, userList) },
                            user = user
                        )

                    }
                }
            }
        }
    }*/