package com.vulong.socialnetwork.presentation.util


sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Main : Screen("main_feed")
    object PostComment : Screen("post_comment")
    object Chat : Screen("chat")
    object Messages : Screen("messages")
    object Profile : Screen("profile")
    object EditProfile : Screen("edit_profile")
    object PersonList : Screen("person_list")
    object CreatePost : Screen("create_post")
    object Activity : Screen("activity")
    object Search : Screen("search")
    object Test : Screen("test")

}
