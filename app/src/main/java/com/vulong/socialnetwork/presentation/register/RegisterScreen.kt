package com.vulong.socialnetwork.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.presentation.components.StandardTextField
import com.vulong.socialnetwork.presentation.login.LoginViewModel
import com.vulong.socialnetwork.presentation.ui.theme.SpaceLarge
import com.vulong.socialnetwork.presentation.ui.theme.SpaceMedium
import com.vulong.socialnetwork.presentation.ui.theme.SpaceSmall
import com.vulong.socialnetwork.presentation.util.Screen

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel(),
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
                text = stringResource(R.string.register_text),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(start = SpaceSmall)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            //email
            StandardTextField(
                text = registerViewModel.emailText.value,
                hint = stringResource(R.string.email_hint),
                maxLength = 40,
                keyboardType = KeyboardType.Email,
                error = registerViewModel.emailError.value,
                onValueChange = {
                    registerViewModel.setEmailText(it)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            //username
            StandardTextField(
                text = registerViewModel.usernameText.value,
                hint = stringResource(R.string.username_hint),
                maxLength = 40,
                error = registerViewModel.usernameError.value,
                onValueChange = {
                    registerViewModel.setUsernameText(it)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            //password
            StandardTextField(
                text = registerViewModel.passwordText.value,
                hint = stringResource(R.string.password_hint),
                maxLength = 20,
                error = registerViewModel.passwordError.value,
                keyboardType = KeyboardType.Password,
                onValueChange = {
                    registerViewModel.setPasswordText(it)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            //register_button
            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    stringResource(R.string.register_text),
                    color = MaterialTheme.colors.onPrimary
                )
            }

        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(id = R.string.already_have_an_account_text)
            )
            Text(text = " ")
            Text(
                text = stringResource(R.string.login_text),
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )

        }
    }
}
