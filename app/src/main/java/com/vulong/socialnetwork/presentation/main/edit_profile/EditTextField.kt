package com.vulong.socialnetwork.presentation.main.edit_profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditTextField(
    text: String,
    hint: String,
    maxLines: Int,
    maxLength: Int,
    onValueChange: (String) -> Unit,

) {
    TextField(
        value = text,
        placeholder = {
            Text(text = hint, style = MaterialTheme.typography.body1)
        },
        maxLines = maxLines,
        onValueChange = {
            if (it.length <= maxLength && !it.contains(" "))
                onValueChange(it)
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun PreEditTextField() {
    EditTextField(text = "", hint = "", maxLines = 1, maxLength = 1, onValueChange = {})
}