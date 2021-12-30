package com.vulong.socialnetwork.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.vulong.socialnetwork.presentation.ui.theme.SpaceSmall

@Composable
fun StandardTextField(
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    singleLine: Boolean = true,
    error: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit,
) {

    val isPasswordToggleDisplayed by rememberSaveable() {
        mutableStateOf(
            keyboardType == KeyboardType.Password
        )
    }

    var isShowPassword by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text,
            placeholder = {
                Text(text = hint, style = MaterialTheme.typography.body1)
            },
            isError = (error != ""),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            singleLine = singleLine,
            onValueChange = {
                if (it.length <= maxLength && !it.contains(" "))
                    onValueChange(it)
            },
            visualTransformation = if (!isShowPassword && isPasswordToggleDisplayed)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,
            leadingIcon = leadingIcon,
            trailingIcon = {
                if (isPasswordToggleDisplayed) {
                    IconButton(onClick = {
                        isShowPassword = !isShowPassword
                    }) {
                        Icon(
                            imageVector = if (isShowPassword) {
                                Icons.Filled.Visibility
                            } else {
                                Icons.Filled.VisibilityOff
                            },
                            tint = MaterialTheme.colors.onBackground,
                            contentDescription = "icon toggle"
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        if (error.isNotEmpty()) {
            Spacer(modifier = Modifier.height(SpaceSmall))
            Text(
                text = error,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                modifier = Modifier
                    .padding(end = SpaceSmall / 2)
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview
@Composable
fun StandardTextFieldPreview() {
    StandardTextField(onValueChange = {})
}