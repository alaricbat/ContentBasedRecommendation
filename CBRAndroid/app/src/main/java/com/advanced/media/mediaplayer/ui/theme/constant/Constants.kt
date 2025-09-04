package com.advanced.media.mediaplayer.ui.theme.constant

import com.advanced.media.mediaplayer.R
import com.advanced.media.mediaplayer.ui.theme.data.BottomNavItemMain

object Constants {

    val BottomNavItemName = listOf(
        BottomNavItemMain(
            label = "For You",
            icon = R.drawable.ic_home,
            route = "for you"
        ),
        BottomNavItemMain(
            label = "Songs",
            icon = R.drawable.ic_audiotrack,
            route = "for you"
        ),
        BottomNavItemMain(
            label = "Albums",
            icon = R.drawable.ic_album,
            route = "albums"
        ),
        BottomNavItemMain(
            label = "Artists",
            icon = R.drawable.ic_artist,
            route = "artists"
        ),
        BottomNavItemMain(
            label = "Playlists",
            icon = R.drawable.ic_queue_music,
            route = "playlists"
        )
    )

}