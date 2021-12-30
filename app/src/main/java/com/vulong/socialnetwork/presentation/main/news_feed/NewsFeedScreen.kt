package com.vulong.socialnetwork.presentation.main.news_feed

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.presentation.components.Post
import com.vulong.socialnetwork.presentation.navigation.Screen
import com.vulong.socialnetwork.presentation.ui.theme.MediumGray
import com.vulong.socialnetwork.presentation.ui.theme.SpaceMedium
import com.vulong.socialnetwork.presentation.ui.theme.TextWhite
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun NewsFeedScreen(appNavController: NavController) {

    val systemUiController = rememberSystemUiController()

    CollapsingToolbarScaffold(
        state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
        modifier = Modifier,
        scrollStrategy = ScrollStrategy.EnterAlways,
        toolbar = {
            TopAppBar(

                title = {
                    Text(
                        text = stringResource(R.string.news_feed_text),
                        style = MaterialTheme.typography.h2
                    )
                },
                actions = {
                    IconButton(onClick = {
                        //todo search action
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "search icon",
                            tint = TextWhite
                        )
                    }
                },
                elevation = 0.dp

            )
        },
        body = {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = MediumGray
                )
//                systemUiController.setNavigationBarColor(
//                    color = MediumGray,
//                )
//                systemUiController.setStatusBarColor(
//                    color = MediumGray,
//                )

            }

            LazyColumn {
                item {
                    Spacer(modifier = Modifier.height(SpaceMedium))
                    Post(onCommentClick = { appNavController.navigate(Screen.PostComment.route) })
                }
                item {
                    Spacer(modifier = Modifier.height(SpaceMedium))
                    Post(onCommentClick = { appNavController.navigate(Screen.PostComment.route) })
                    Spacer(modifier = Modifier.height(SpaceMedium))

                }
                item {
                    Spacer(modifier = Modifier.height(SpaceMedium))
                    Post(onCommentClick = { appNavController.navigate(Screen.PostComment.route) })
                    Spacer(modifier = Modifier.height(SpaceMedium))

                }
            }
        },
    )
}