package com.vulong.socialnetwork.presentation.main.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenInMain(
    val route: String,
    val iconFilled: ImageVector,
    val iconOutlined: ImageVector,
) {
    object NewsFeed : ScreenInMain(
        "news_feed",
        Icons.Filled.Home,
        Icons.Outlined.Home
    )

    object Chat : ScreenInMain(
        "chat",
        Icons.Filled.Message,
        Icons.Outlined.Message
    )

    object FloatingActionButtonPlaceHolder : ScreenInMain(
        "fab",
        Icons.Filled.Message,
        Icons.Outlined.Message
    )

    object Notification : ScreenInMain(
        "notification",
        Icons.Filled.Notifications,
        Icons.Outlined.Notifications
    )

    object Profile : ScreenInMain(
        "profile",
        Icons.Filled.Person,
        Icons.Outlined.Person
    )
}