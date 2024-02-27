package views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.ui_practica.ui.viewmodels.ContactDetailsViewModel

@Composable
fun ContactDetails(
    contactDetailsViewModel: ContactDetailsViewModel,
    navController: NavHostController
) {
    Text("Pantalla de inicio")
}