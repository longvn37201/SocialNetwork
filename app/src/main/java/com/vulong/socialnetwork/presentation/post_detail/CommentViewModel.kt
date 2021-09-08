package com.vulong.socialnetwork.presentation.post_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor() : ViewModel() {

    private val _commentText = mutableStateOf("")
    val commentText: State<String> = _commentText


    fun setUsernameText(comment: String) {
        _commentText.value = comment
    }


}