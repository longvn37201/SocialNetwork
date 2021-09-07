package com.vulong.socialnetwork.presentation.util

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vulong.socialnetwork.presentation.login.LoginScreen
import com.vulong.socialnetwork.presentation.login.LoginViewModel
import com.vulong.socialnetwork.presentation.main.MainScreen
import com.vulong.socialnetwork.presentation.post_detail.CommentPostScreen
import com.vulong.socialnetwork.presentation.register.RegisterScreen
import com.vulong.socialnetwork.presentation.register.RegisterViewModel

@Composable
fun AppNavigation() {
    val appNavController = rememberNavController()
    NavHost(navController = appNavController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                navController = appNavController,
                loginViewModel = loginViewModel
            )
        }
        composable(Screen.Register.route) {
            val registerViewModel = hiltViewModel<RegisterViewModel>()
            RegisterScreen(
                navController = appNavController,
                registerViewModel = registerViewModel
            )
        }
        composable(Screen.Main.route) {
//            val registerViewModel = hiltViewModel<RegisterViewModel>()
            MainScreen(
                appNavController = appNavController,
//                registerViewModel = registerViewModel
            )
        }
        composable(Screen.PostComment.route) {
            CommentPostScreen(
                appNavController = appNavController,
            )
        }
    }
}