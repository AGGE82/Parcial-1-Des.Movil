package com.example.ui_practica.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui_practica.ui.viewmodels.ContactDetailsViewModel
import com.example.ui_practica.ui.viewmodels.HomeScreenViewModel
import com.example.ui_practica.ui.viewmodels.NewUsersViewModel
import com.example.ui_practica.ui.viewmodels.UsersListViewModel
import views.ContactDetails
import views.HomeScreen
import views.NewUser
import views.UsersList

@Composable
fun NavManagement(newUsersViewModel: NewUsersViewModel) {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){
        composable("NewUser"){
            NewUser(NewUsersViewModel(),navController)
        }
        composable("Home"){
            HomeScreen(HomeScreenViewModel(),navController)
        }
        composable("ContactDetails"){
            ContactDetails(ContactDetailsViewModel(), navController)
        }
        composable("UsersList"){
            UsersList(UsersListViewModel(), NewUsersViewModel(), navController)
        }
    }
}

