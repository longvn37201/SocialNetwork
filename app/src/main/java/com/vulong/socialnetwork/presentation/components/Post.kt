package com.vulong.socialnetwork.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vulong.socialnetwork.R
import com.vulong.socialnetwork.presentation.ui.theme.*
import com.vulong.socialnetwork.util.Constants

@Composable
fun Post(
//    post: Post,
    profilePictureSize: Dp = 64.dp,
//    onUsernameClick: (String) -> Unit,
    onCommentClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = SpaceSmall)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = profilePictureSize / 2)
                .clip(MaterialTheme.shapes.medium)
                .background(MediumGray)
        ) {
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

                },
                onCommentClick = {
                    onCommentClick()
                },
                onShareClick = {

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
        //avatar
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentScale = ContentScale.Crop,
            contentDescription = "avatar",
            modifier = Modifier
                .size(profilePictureSize)
                .fillMaxSize()
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        )
    }
}

@Composable
fun ActionRow(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    username: String = "vulong2504",
    onUsernameClick: (String) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = username,
            style = TextStyle(
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            modifier = Modifier.clickable {
                onUsernameClick(username)
            }
        )

        InteractionButtonRow(
            isLiked = isLiked,
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick,
        )
    }

}

@Composable
fun InteractionButtonRow(
    modifier: Modifier = Modifier,
    iconSize: Dp = 40.dp,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(
            onClick = { onLikeClick(!isLiked) },
            Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "like button",
                tint = if (isLiked) Color.Red else TextWhite
            )
        }
        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(
            onClick = { onCommentClick() },
            Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = "like button",
                tint = MaterialTheme.colors.onBackground
            )
        }
        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(
            onClick = { onShareClick() },
            Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "like button",
                tint = MaterialTheme.colors.onBackground
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF404040, showSystemUi = true)
@Composable
fun PostPreview() {
    SocialNetworkTheme {
        Post(onCommentClick = {})
    }
}

