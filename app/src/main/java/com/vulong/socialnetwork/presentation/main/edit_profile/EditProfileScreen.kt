package com.vulong.socialnetwork.presentation.main.edit_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ExperimentalAnimatedInsets
import com.google.accompanist.insets.rememberImeNestedScrollConnection
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.presentation.components.StandardTextField
import com.vulong.socialnetwork.presentation.ui.theme.AvatarInProfile
import com.vulong.socialnetwork.presentation.ui.theme.SpaceLarge
import com.vulong.socialnetwork.presentation.ui.theme.TextWhite

@OptIn(ExperimentalAnimatedInsets::class)
@Composable
fun EditProfileScreen(
    appNavController: NavController,
) {
        Scaffold(
            modifier = Modifier,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Edit profile",
                            style = MaterialTheme.typography.h2
                        )
                    },
                    actions = {
                        IconButton(onClick = {
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "save profile",
                                tint = TextWhite
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { appNavController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "back",
                                tint = TextWhite
                            )
                        }
                    },
                    elevation = 0.dp
                )
            },
        ) { contentPadding ->
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .nestedScroll(connection = rememberImeNestedScrollConnection())
                    .verticalScroll(state = rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                //wallpaper + avt
                Box {
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
                    ) {}
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentScale = ContentScale.Crop,
                        contentDescription = "avatar",
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = AvatarInProfile / 2)
                            .size(AvatarInProfile)
                            .clip(CircleShape)
                    )
                }
                Spacer(modifier = Modifier.height(AvatarInProfile / 2 + SpaceLarge))
                //edit username
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = SpaceLarge, end = SpaceLarge, bottom = SpaceLarge)
                ) {
                    var text by remember { mutableStateOf("") }
                    StandardTextField(
                        text = text,
                        hint = "Username",
                        maxLength = 20,
                        onValueChange = { text = it },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_person),
                                contentDescription = "leading icon"
                            )
                        }
                    )
                }
                //edit ins
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = SpaceLarge, end = SpaceLarge, bottom = SpaceLarge)
                ) {
                    var text by remember { mutableStateOf("") }
                    StandardTextField(
                        text = text,
                        hint = "Instagram",
                        maxLength = 20,
                        onValueChange = { text = it },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_instagram),
                                contentDescription = "leading icon"
                            )
                        }
                    )
                }
                //edit github
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = SpaceLarge, end = SpaceLarge, bottom = SpaceLarge)
                ) {
                    var text by remember { mutableStateOf("") }
                    StandardTextField(
                        text = text,
                        hint = "Github",
                        maxLength = 20,
                        onValueChange = { text = it },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_github),
                                contentDescription = "leading icon"
                            )
                        }
                    )
                }
                //edit linkedin
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = SpaceLarge, end = SpaceLarge, bottom = SpaceLarge)
                ) {
                    var text by remember { mutableStateOf("") }
                    StandardTextField(
                        text = text,
                        hint = "Linkedin",
                        maxLength = 20,
                        onValueChange = { text = it },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_linkedin),
                                contentDescription = "leading icon"
                            )
                        }
                    )
                }
                //edit des
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = SpaceLarge, end = SpaceLarge, bottom = SpaceLarge)
                ) {
                    var text by remember { mutableStateOf("") }
                    StandardTextField(
                        text = text,
                        hint = "Linkedin",
                        maxLength = 100,
                        singleLine = false,
                        onValueChange = { text = it },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_description),
                                contentDescription = "leading icon"
                            )
                        }
                    )
                }
            }
        }

}


@Preview
@Composable
fun EditPre() {
    EditProfileScreen(appNavController = rememberNavController())
}