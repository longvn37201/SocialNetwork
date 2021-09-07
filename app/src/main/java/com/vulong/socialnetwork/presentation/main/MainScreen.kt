package com.vulong.socialnetwork.presentation.main

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.FloatingActionButtonDefaults.elevation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.presentation.main.util.MainNavigation
import com.vulong.socialnetwork.presentation.main.util.ScreenInMain
import com.vulong.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.vulong.socialnetwork.presentation.ui.theme.SpaceSmall
import com.vulong.socialnetwork.presentation.ui.theme.TextWhite

@Composable
fun MainScreen(appNavController: NavController) {

    val mainNavController = rememberNavController()


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //todo FAB button
                },
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,

        bottomBar = {
            BottomAppBar(
                cutoutShape = RoundedCornerShape(50),
                content = {
                    CustomBottomNavigation(mainNavController)
                },
                modifier = Modifier.fillMaxWidth(),
                elevation = 0.dp
            )
        },

        ) { innerPadding ->
        MainNavigation(
            mainNavController = mainNavController,
            appNavController = appNavController,
            innerPadding = innerPadding
        )
    }
}

@Composable
fun CustomBottomNavigation(mainNavController: NavController) {

    val items = listOf(
        ScreenInMain.NewsFeed,
        ScreenInMain.Chat,
        ScreenInMain.FloatingActionButtonPlaceHolder,
        ScreenInMain.Notification,
        ScreenInMain.Profile,
    )
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp
    ) {
        val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            run {
                if (screen.route != "fab") {
                    //basic nav item
                    BottomNavigationItem(
                        icon = {
                            if (currentDestination?.hierarchy?.any { it.route == screen.route } == true)
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    Icon(
                                        imageVector = screen.iconFilled,
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Spacer(modifier = Modifier.height(SpaceSmall / 2))
                                    Divider(
                                        color = MaterialTheme.colors.primary,
                                        modifier = Modifier
                                            .height(1.dp)
                                            .width(35.dp)
                                            .clip(MaterialTheme.shapes.medium)
                                    )
                                }
                            else
                                Box(modifier = Modifier.size(45.dp)) {
                                    Icon(
                                        imageVector = screen.iconOutlined,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(30.dp)
                                            .align(Alignment.Center)
                                    )
                                    Box(
                                        modifier = Modifier
                                            .align(Alignment.TopEnd)
                                            .size(17.dp)
                                            .clip(CircleShape)
                                            .background(MaterialTheme.colors.primary)
                                    ) {
                                        Text(
                                            text = "5",
                                            color = Color.Black,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier
                                                .align(Alignment.Center)

                                        )
                                    }
                                }
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        selectedContentColor = MaterialTheme.colors.primary,
                        unselectedContentColor = MaterialTheme.colors.onSurface,
                        onClick = {
                            mainNavController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(mainNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                    )
                } else {
                    //fab place holder item
                    BottomNavigationItem(
                        selected = false,
                        onClick = { },
                        icon = {},
                        enabled = false
                    )
                }
            }


        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    SocialNetworkTheme {
        MainScreen(appNavController = rememberNavController())
    }
}