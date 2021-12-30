package com.vulong.socialnetwork.presentation.main.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vulong.socialnetwork.presentation.main.chat.ChatScreen
import com.vulong.socialnetwork.presentation.main.news_feed.NewsFeedScreen
import com.vulong.socialnetwork.presentation.main.notification.NotificationScreen
import com.vulong.socialnetwork.presentation.main.profile.ProfileScreen

@Composable
fun MainNavigation(
    mainNavController: NavHostController,
    appNavController: NavController,
    innerPadding: PaddingValues,
) {
    NavHost(
        mainNavController,
        startDestination = ScreenInMain.NewsFeed.route,
        Modifier.padding(innerPadding)//padding scroll
    ) {
        composable(ScreenInMain.NewsFeed.route) {
            NewsFeedScreen(appNavController)
        }
        composable(ScreenInMain.Chat.route) {
            ChatScreen(appNavController)
        }
        composable(ScreenInMain.Notification.route) {
            NotificationScreen(appNavController)
        }
        composable(ScreenInMain.Profile.route) {
            ProfileScreen(appNavController)
        }
    }
}

