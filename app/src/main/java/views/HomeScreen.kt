package views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.ui_practica.ui.components.ButtonNewUserPage
import com.example.ui_practica.ui.components.ButtonUserListPage
import com.example.ui_practica.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel, navController: NavHostController) {
    Column(){
        ButtonNewUserPage {navController.navigate("NewUser")}
        ButtonUserListPage(enabled = true) {navController.navigate("UsersList")}
    }
}