package com.vulong.socialnetwork.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.presentation.components.StandardTextField
import com.vulong.socialnetwork.presentation.ui.theme.DarkGray
import com.vulong.socialnetwork.presentation.ui.theme.SpaceLarge
import com.vulong.socialnetwork.presentation.ui.theme.SpaceMedium
import com.vulong.socialnetwork.presentation.ui.theme.SpaceSmall
import com.vulong.socialnetwork.presentation.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel(),
) {
    Box(
        modifier = Modifier
            .padding(
                start = SpaceLarge, end = SpaceLarge,
                bottom = 50.dp
            )
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {

            Text(
                text = stringResource(R.string.login_text),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(start = SpaceSmall)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            //username
            StandardTextField(
                text = loginViewModel.usernameText.value,
                hint = stringResource(R.string.username_and_email_hint),
                maxLength = 40,
                keyboardType = KeyboardType.Email,
                error = loginViewModel.usernameError.value,
                onValueChange = {
                    loginViewModel.setUsernameText(it)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            //password
            StandardTextField(
                text = loginViewModel.passwordText.value,
                hint = stringResource(R.string.password_hint),
                maxLength = 20,
                error = loginViewModel.passwordError.value,
                keyboardType = KeyboardType.Password,
                onValueChange = {
                    loginViewModel.setPasswordText(it)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            //login_button
            Button(
                onClick = {
                    navController.navigate(Screen.Main.route)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    stringResource(R.string.login_text),
                    color = MaterialTheme.colors.onPrimary
                )
            }

        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(id = R.string.dont_have_account_text)
            )
            Text(" ")
            Text(
                text = stringResource(R.string.register_text),
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    navController.navigate(
                        Screen.Register.route
                    )
                }
            )

        }

    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setStatusBarColor(
            color = DarkGray,
        )

        // setStatusBarsColor() and setNavigationBarsColor() also exist
    }
}
