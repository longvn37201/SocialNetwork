package com.vulong.socialnetwork.presentation.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.presentation.components.ActionRow
import com.vulong.socialnetwork.presentation.ui.theme.*
import com.vulong.socialnetwork.util.Constants

@Composable
fun ProfileScreen(appNavController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Your profile",
                        style = MaterialTheme.typography.h2
                    )
                },
                actions = {
                    IconButton(onClick = {
                        //three dot in profile
                    }) {
                        Icon(imageVector = Icons.Filled.MoreVert,
                            contentDescription = "more option", tint = TextWhite)
                    }
                },
                elevation = 0.dp
            )
        },

        ) {
        LazyColumn() {
            item {
                ConstraintLayout {
                    val (wallpaper, avatar, info) = createRefs()
                    WallpaperItem(
                        modifier = Modifier.constrainAs(wallpaper) {
                            top.linkTo(parent.top)
                        }
                    )
                    InfoItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(info) {
                                top.linkTo(wallpaper.bottom)
                            }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentScale = ContentScale.Crop,
                        contentDescription = "avatar",
                        modifier = Modifier
                            .size(80.dp)
                            .fillMaxSize()
                            .clip(CircleShape)
                            .constrainAs(avatar) {
                                top.linkTo(wallpaper.bottom)
                                bottom.linkTo(info.top)
                                centerHorizontallyTo(parent)
                            }
                    )
                }
            }
            item {
                Column() {
                    Spacer(modifier = Modifier.height(SpaceMedium))
                    PostItem(onCommentClick = { /*TODO*/ }, onLikeClick = { /*TODO*/ }) {

                    }
                    Spacer(modifier = Modifier.height(SpaceMedium))
                    PostItem(onCommentClick = { /*TODO*/ }, onLikeClick = { /*TODO*/ }) {

                    }
                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
            }
        }

    }

}

@Composable
fun WallpaperItem(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = com.vulong.socialnetwork.R.drawable.wallpaper),
            contentDescription = "wallpaper",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color(0x92000000))
                    )
                )
        ) {

        }
    }
}

@Composable
fun InfoItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        //Name,
        Text(
            text = "Vũ Long",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = TextWhite
        )

        Spacer(modifier = Modifier.height(SpaceSmall))
        //bio text
        Text(
            text = "Duis nec erat dolor. Nulla vitae consectetur ligula. Quisque nec mi est. Ut" +
                    "quam ante, rutrum at pellentesque gravida, pretium in dui. Cras eget sapien" +
                    "velit. Suspendisse ut sem nec tellus vehicula eleifend sit amet quis velit." +
                    "Phasellus quis suscipit nisi. Nam",
            style = MaterialTheme.typography.body2,
            color = TextWhite,
            maxLines = 4,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = SpaceMedium)
        )
        Spacer(modifier = Modifier.height(SpaceSmall))
        //follow info row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //folower colum
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "86",
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp,
                    color = TextWhite,
                    fontWeight = FontWeight.Bold)
                Text(
                    text = "Followers",
                    style = MaterialTheme.typography.body2,
                    fontSize = 18.sp,
                    color = TextWhite,
                )
            }
            //flowing
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "86",
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp,
                    color = TextWhite,
                    fontWeight = FontWeight.Bold)
                Text(
                    text = "Following",
                    style = MaterialTheme.typography.body2,
                    fontSize = 18.sp,
                    color = TextWhite,
                )
            }
            //post
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "206",
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp,
                    color = TextWhite,
                    fontWeight = FontWeight.Bold)
                Text(
                    text = "Posts",
                    style = MaterialTheme.typography.body2,
                    fontSize = 18.sp,
                    color = TextWhite,
                )
            }
            //folow button
            Button(
                onClick = {
                    //folow person
                },
            ) {
                Text(
                    "Follow",
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

@Composable
fun PostItem(
    profilePictureSize: Dp = 64.dp,
    onCommentClick: () -> Unit,
    onLikeClick: () -> Unit,
    onShareClick: () -> Unit,

    ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = SpaceMedium)
            .clip(MaterialTheme.shapes.medium)
            .background(MediumGray)
    ) {
        //image
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = "wallpaper",
        )
        Spacer(modifier = Modifier.height(SpaceMedium))
        ActionRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = SpaceMedium
                ),
            onLikeClick = {
                onLikeClick()
            },
            onCommentClick = {
                onCommentClick()
            },
            onShareClick = {
                onShareClick()
            },
            onUsernameClick = {
            }
        )
        Spacer(modifier = Modifier.height(SpaceMedium))
        //content
        Text(
            modifier = Modifier.padding(horizontal = SpaceMedium),
            text = buildAnnotatedString {
                append(stringResource(R.string.test_text))
                append(" ")
                withStyle(
                    SpanStyle(
                        color = HintGray
                    )
                ) {
                    append("Read more")
                }
            },
            style = MaterialTheme.typography.body1,
            color = TextWhite,
            maxLines = Constants.MAX_POST_DESCRIPTION_LINES,
            overflow = TextOverflow.Ellipsis,
        )
        val a = 15
        val b = 15
        Spacer(modifier = Modifier.height(SpaceMedium))
        //like cmt count
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = SpaceMedium),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Liked by $a people",
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1)
            Text(
                text = "$b comments",
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.clickable {
                    onCommentClick()
                }
            )
        }
        Spacer(modifier = Modifier.height(SpaceMedium))
    }
}


