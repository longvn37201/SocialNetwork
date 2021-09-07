package com.vulong.socialnetwork.presentation.post_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.domain.models.Comment
import com.vulong.socialnetwork.domain.models.Post
import com.vulong.socialnetwork.presentation.ui.theme.SpaceMedium
import com.vulong.socialnetwork.presentation.ui.theme.SpaceSmall
import com.vulong.socialnetwork.presentation.ui.theme.TextWhite

@Composable
fun CommentPostScreen(
    appNavController: NavController,
    post: Post = Post("", "", "", "", 5, 5),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.comments_text),
                        style = MaterialTheme.typography.h2
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { appNavController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back icon",
                            tint = TextWhite
                        )
                    }
                },
                elevation = 0.dp
            )
        },
    ) {
        Column {
            Comment()
            Comment()
            Comment()
        }

    }
}

@Composable
fun Comment(comment: Comment) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = SpaceMedium)
            .clip(MaterialTheme.shapes.medium)
            .clickable { }
            .background(MaterialTheme.colors.surface)
            .padding(SpaceMedium),

        ) {
        //info cmt row
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),

            ) {
            //avatar and username
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(SpaceSmall))
                Text(
                    text = "vulong2504",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    color = TextWhite,
                    fontSize = 14.sp
                )

            }
            //time
            Text(
                "2 days ago",
                style = MaterialTheme.typography.body2,
                color = TextWhite
            )
        }
        Spacer(modifier = Modifier.height(SpaceSmall))
        //content cmt
        Text(
            text = "Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem",
            color = TextWhite
        )
        Spacer(modifier = Modifier.height(SpaceSmall))
        //like by and like icon
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Liked by 16 people",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = TextWhite
            )
            IconButton(
                onClick = {
                    //todo like cmt
                }) {
                Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "like")
            }
        }
    }
}