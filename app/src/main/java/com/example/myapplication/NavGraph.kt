package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetNavGraph(
    navController: NavHostController,
    startDestination: Screen.Home,
){
    NavHost(navController = navController as NavHostController, graph = )
}