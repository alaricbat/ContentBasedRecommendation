package com.advanced.media.mediaplayer.ui.theme.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItemMain (
    // text for icon
    val label: String,
    // icon
    @DrawableRes val icon: Int,
    // route to specific screen
    val route: String
)