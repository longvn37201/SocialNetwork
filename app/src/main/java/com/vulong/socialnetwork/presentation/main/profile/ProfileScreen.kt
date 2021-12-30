package com.vulong.socialnetwork.presentation.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.presentation.components.ActionRow
import com.vulong.socialnetwork.presentation.navigation.Screen
import com.vulong.socialnetwork.presentation.ui.theme.*
import com.vulong.socialnetwork.util.Constants
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun ProfileScreen(
    appNavController: NavController,
//    user: User = User(),
) {
    CollapsingToolbarScaffold(
        state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
        modifier = Modifier,
        scrollStrategy = ScrollStrategy.EnterAlways,
        toolbar = {
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
//        fake data
        LazyColumn() {
            //info
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
                            },
                        onEditProfileClicked = {
                            appNavController.navigate(Screen.EditProfile.route)
                        }
                    )
                    //avt
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentScale = ContentScale.Crop,
                        contentDescription = "avatar",
                        modifier = Modifier
                            .size(AvatarInProfile)
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
            //posts
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
        //wallpaper pic
        Image(
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = "wallpaper",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        //brush bottom wallpaper
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color(0xC8000000))
                    )
                )
        ) {

        }

//        //skill and link
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .align(Alignment.BottomCenter),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                IconButton(onClick = { }) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_java),
//                        contentDescription = "icon skill",
//                        modifier = Modifier.size(24.dp)
//                    )
//                }
//                IconButton(onClick = { }) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_kotlin),
//                        contentDescription = "icon skill",
//                        modifier = Modifier.size(24.dp)
//                    )
//                }
//                IconButton(onClick = { }) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_python),
//                        contentDescription = "icon skill",
//                        modifier = Modifier.size(24.dp)
//                    )
//                }
//            }
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_github),
//                        contentDescription = "icon link to github"
//                    )
//                }
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_instagram),
//                        contentDescription = "icon link to instagram"
//                    )
//                }
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_linkedin),
//                        contentDescription = "icon link to linkedin"
//                    )
//                }
//            }
//        }
    }
}


@Composable
fun InfoItem(
    modifier: Modifier = Modifier,
    onEditProfileClicked: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        //Name,
        Box() {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Vũ Long",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = TextWhite
            )
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd).offset(x = 45.dp),
                onClick = { onEditProfileClicked() }) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "edit")
            }
        }

        Spacer(modifier = Modifier.height(SpaceSmall))
        //bio text
        Text(
            text = "Duis nec erat dolor. Nulla vitae consectetur ligula. Quisque nec mi est. Ut" +
                    "quam ante, rutrum at pellentesque gravida, pretium in dui. Cras eget sapien" +
                    "velit. Suspendisse ut sem nec tellus vehicula eleifend sit amet quis velit." +
                    "Phasellus quis suscipit nisi. Nam",
            style = MaterialTheme.typography.body1,
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
                    color = TextWhite,
                    fontWeight = FontWeight.Bold)
                Text(
                    text = "Followers",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite,
                )
            }
            //flowing
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "86",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite,
                    fontWeight = FontWeight.Bold)
                Text(
                    text = "Following",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite,
                )
            }
            //post
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "206",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite,
                    fontWeight = FontWeight.Bold)
                Text(
                    text = "Posts",
                    style = MaterialTheme.typography.body1,
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


@Preview
@Composable
fun ProfilePrev() {
    ProfileScreen(appNavController = rememberNavController())
}