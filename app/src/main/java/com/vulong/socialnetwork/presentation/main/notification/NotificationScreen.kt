package com.vulong.socialnetwork.presentation.main.notification

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vulong.socialnetwork.presentation.ui.theme.SpaceMedium
import com.vulong.socialnetwork.presentation.ui.theme.SpaceSmall
import com.vulong.socialnetwork.presentation.ui.theme.TextWhite
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun NotificationScreen(appNavController: NavController) {
    CollapsingToolbarScaffold(
        state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
        modifier = Modifier,
        scrollStrategy = ScrollStrategy.EnterAlways,
        toolbar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Notifications",
                        style = MaterialTheme.typography.h2
                    )
                },
                elevation = 0.dp
            )
        },
    ) {
        LazyColumn() {
            for (i in 1..20) {
                item {
                    Column {
                        Spacer(modifier = Modifier.height(SpaceMedium))
                        NotificationItem()
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
        }
    }

}

@Composable
fun NotificationItem() {
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .padding(horizontal = SpaceSmall)
            .clip(MaterialTheme.shapes.small)
            .clickable { },
    ) {
        Row(Modifier
            .fillMaxWidth()
            .padding(SpaceMedium), Arrangement.SpaceBetween) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    ) {
                        append("vulong2504")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = TextWhite,
                            fontSize = 16.sp
                        )
                    ) {
                        append(" liked")

                    }
                    withStyle(
                        style = SpanStyle(
                            color = TextWhite,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    ) {
                        append(" Your post")
                    }
                }
            )
            Text(text = "Sep 8, 22:29", style = TextStyle(
                color = TextWhite,
                fontSize = 16.sp
            ))
        }
    }
}
