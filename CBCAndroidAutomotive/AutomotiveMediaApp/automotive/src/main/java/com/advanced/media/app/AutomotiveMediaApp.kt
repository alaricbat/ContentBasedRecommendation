package com.advanced.media.app

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.advanced.media.app.presentation.ui.component.AutomotiveMediaNavHost
import com.advanced.media.app.presentation.ui.screen.Screen
import com.advanced.media.app.presentation.ui.theme.dm_container_color
import com.advanced.media.app.presentation.ui.theme.md_theme_light_onPrimary
import dagger.hilt.android.HiltAndroidApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutomotiveMediaApp (
    windowSizeClass: WindowSizeClass?
) {

    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val currentBackStackEntryState = navController.currentBackStackEntryAsState()
    val currentBackStackEntry = currentBackStackEntryState.value
    val route = currentBackStackEntry?.destination?.route

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
//            if (route?.equals(Screen.MAIN.name) == true) {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = dm_container_color,
                        titleContentColor = Color.White
                    ),
                    windowInsets = WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal + WindowInsetsSides.Top),
                    title = {

                        var expanded by rememberSaveable { mutableStateOf(false) }
                        val searchResults = mutableListOf<String>()

                        SearchBar(
                            modifier = Modifier
                                .semantics { isTraversalGroup = true }
                                .padding(
                                    vertical = 10.dp
                                ),
                            inputField = {
                                SearchBarDefaults.InputField(
                                    query = "",
                                    onQueryChange = {

                                    },
                                    onSearch = {

                                    },
                                    expanded = expanded,
                                    onExpandedChange = { expanded = it },
                                    placeholder = {
                                        Text(text = "Search")
                                    }
                                )
                            },
                            expanded = expanded,
                            onExpandedChange = { expanded = it },
                        ) {
                            Column(Modifier.verticalScroll(rememberScrollState())) {
                                searchResults.forEach { result ->
                                    ListItem(
                                        headlineContent = { Text(result) },
                                        modifier = Modifier
                                            .clickable { }
                                            .fillMaxWidth()
                                    )
                                }
                            }
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                        }
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
//            } else if (route?.startsWith(Screen.DETAIL.name) == true) {
//                CenterAlignedTopAppBar(
//                    windowInsets = WindowInsets.safeDrawing.only(
//                        WindowInsetsSides.Horizontal + WindowInsetsSides.Top
//                    ),
//                    title = { Text(text = stringResource(R.string.app_name)) },
//                    navigationIcon = {
//                        IconButton(onClick = { navController.popBackStack() }) {
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                                contentDescription = null
//                            )
//                        }
//                    }
//                )
//            }
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding),
            color = if (route?.equals(Screen.PLAYER.name) == true) Color.Black else
                    MaterialTheme.colorScheme.background
        ) {
            if (windowSizeClass != null) {
                AutomotiveMediaNavHost(
                    windowSizeClass,
                    navController
                )
            } else {
                Text("Unknown")
            }

        }
    }
}


@Preview
@Composable
fun PreviewAutomotiveMediaApp() {
    AutomotiveMediaApp(
        null
    )
}

@HiltAndroidApp
class AutomotiveMediaApplication: Application() {

}