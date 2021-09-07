package com.vulong.socialnetwork.domain.models

data class Comment(
    val commentId: Int = -1,
    val username: String = "",
    val profilePictureUrl: String = "",
    val timeStamp: Long = System.currentTimeMillis(),
    val comment: String = "",
    val likeCount: Int = 0,
)